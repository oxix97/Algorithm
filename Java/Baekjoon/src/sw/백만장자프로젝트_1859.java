package src.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만장자프로젝트_1859 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long max = 0;
            long answer = 0;
            for (int k = n; k > 1; k--) {
                max = Math.max(max, arr[k]);
                if (arr[k] >= arr[k - 1]) {
                    answer += max - arr[k - 1];
                } else {
                    max = 0;
                }
            }
            append(i, answer);
        }
        System.out.println(sb);
        br.close();
    }

    private static void append(int idx, long answer) {
        sb.append("#").append(idx).append(' ').append(answer).append('\n');
    }
}
