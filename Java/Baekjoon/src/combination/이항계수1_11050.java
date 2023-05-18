package src.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수1_11050 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][1] = i; // i개중 1개를 뽑는 경우
            dp[i][0] = 1; // i개중 0개를 뽑는 경우
            dp[i][i] = 1; // i개중 i개를 뽑는 경우
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        System.out.println(dp[N][K]);
        br.close();
    }
}
