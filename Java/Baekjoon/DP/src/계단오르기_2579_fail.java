import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579_fail {
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

        recursion(N, 1, 0);

        if (N >= 2) {
            System.out.println(Math.max(ans[1], ans[2]));
        }else{
            System.out.println(arr[1]);
        }
    }

    private static void recursion(int n, int cnt, int value) {
        if (n < 1 || ans[n] > arr[n] + value) return;

        ans[n] = value + arr[n];

        if (cnt == 2) {
            recursion(n - 2, 1, ans[n]);
        } else {
            recursion(n - 1, ++cnt, ans[n]);
            recursion(n - 2, 1, ans[n]);
        }
    }
}
