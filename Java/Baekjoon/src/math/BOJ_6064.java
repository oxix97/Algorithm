package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, M, N, x, y;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int answer = -1;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int lcm = M * N / gcd(M, N);
            int cnt = 0;
            while (cnt * M < lcm) {
                if ((cnt * M + x - y) % N == 0) {
                    answer = cnt * M + x;
                    break;
                }
                cnt++;
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static int gcd(int m, int n) {
        if (n == 0) return m;
        return gcd(n, m % n);
    }
}
