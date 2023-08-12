package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20529 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new char[N][4];

            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken().toCharArray();
            }

            int min = Integer.MAX_VALUE;

            if (N > 32) {
                sb.append(0).append('\n');
                continue;
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        int x = distance(arr[i], arr[j]);
                        int y = distance(arr[j], arr[k]);
                        int z = distance(arr[i], arr[k]);
                        min = Math.min(min, (x + y + z));
                    }
                }
            }
            sb.append(min).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static int solution() {
        int min = Integer.MAX_VALUE;
        if (N > 32) {
            return 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int x = distance(arr[i], arr[j]);
                    int y = distance(arr[j], arr[k]);
                    int z = distance(arr[i], arr[k]);
                    min = Math.min(min, (x + y + z));
                }
            }
        }
        return min;
    }

    private static int distance(char[] a, char[] b) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (a[i] != b[i]) ++cnt;
        }
        return cnt;
    }
}
