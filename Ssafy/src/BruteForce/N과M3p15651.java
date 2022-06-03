package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M3p15651 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        input();
        recursion(0);
        System.out.println(sb.toString());
    }

    private static void recursion(int n) {
        if (n == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                boolean isUsed = false;
                for (int k = 0; k < n; k++) {
                    if (selected[k] == i) {
                        isUsed = true;
                        break;
                    }
                }
                if (!isUsed) {
                    selected[n] = i;
                    recursion(n + 1);
                }
            }
        }
    }

    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
    }
}
