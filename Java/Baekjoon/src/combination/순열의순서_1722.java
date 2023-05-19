package src.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 순열의순서_1722 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list;
    static int N, Q;
    static long K; // N -> N! , Q : 문제 종류, K : k번째 수열
    static long[] F;
    static int[] S;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());
        S = new int[21];
        F = new long[21];
        F[0] = 1;
        visited = new boolean[21];

        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        if (Q == 1) {
            K = Long.parseLong(st.nextToken());
            for (int i = 1; i <= N; i++) {
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if (visited[j]) continue;
                    if (K <= F[N - i] * cnt) {
                        K -= F[N - i] * (cnt - 1);
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    ++cnt;
                }
            }
            for (int i = 1; i <= N; i++) {
                sb.append(S[i]).append(' ');
            }
        } else {
            K = 1;
            for (int i = 1; i <= N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < S[i]; j++) {
                    if (!visited[j]) {
                        ++cnt;
                    }
                }
                K += cnt * F[N - i];
                visited[S[i]] = true;
            }
            sb.append(K);
        }
        System.out.println(sb);
    }
}
