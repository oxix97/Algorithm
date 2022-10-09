import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470_TwoPointer {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        int L = 1, R = N, ans = Integer.MAX_VALUE;
        int num1 = 0, num2 = 0;
        while (L < R) {
            int sum = arr[L] + arr[R];
            if (ans > Math.abs(sum)) {
                ans = Math.abs(sum);
                num1 = arr[L];
                num2 = arr[R];
            }
            if (sum < 0) {
                ++L;
            } else if (sum == 0) {
                break;
            } else {
                --R;
            }
        }
        sb.append(num1).append(' ').append(num2);
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 1, N + 1);
    }
}
