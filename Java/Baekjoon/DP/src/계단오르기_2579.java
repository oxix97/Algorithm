import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {
    static int[] arr;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        ans[1] = arr[1];
        ans[2] = arr[1] + arr[2];
        ans[3] = Math.max(arr[1], arr[2]) + arr[3];

        for (int i = 4; i <= N; i++) {
            ans[i] = Math.max(ans[i - 2], ans[i - 3] + arr[i - 1]) + arr[i];
        }
        System.out.println(ans[N]);
    }
}
