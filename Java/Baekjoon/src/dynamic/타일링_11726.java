package src.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타일링_11726 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N; // (1~1000)
    static long[] dp;
    static final int NUMBER = 10007;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % NUMBER;
        }
        System.out.println(dp[N]);

        br.close();
    }
}
