package src.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부녀회장이될테야_2775 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        // T: test_case, K 층 n호

        //2. dp 배열 생성
        dp = new int[15][15];
        for (int n = 1; n <= 14; n++) {
            dp[0][n] = n;
            dp[n][1] = 1;
        }

        for (int k = 1; k <= 14; k++) {
            for (int n = 2; n <= 14; n++) {
                dp[k][n] = dp[k][n - 1] + dp[k - 1][n];
            }
        }

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
