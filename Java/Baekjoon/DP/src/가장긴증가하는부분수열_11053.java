import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_11053 {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                //현재 검토중인 arr[i]보다 작고, 부분 수열 크기도 작은 경우
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1)
                    //dp[j] + 1 하는 이유 -> 이전에 찾은 것에서 원소가 추가되었기 때문
                    dp[i] = dp[j] + 1;
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N - 1]);
    }
}
