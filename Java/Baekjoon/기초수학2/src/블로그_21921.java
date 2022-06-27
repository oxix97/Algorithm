import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 블로그_21921 {
    static int X;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[250_001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 1; i <= X; i++) {
            sum += arr[i];
        }

        long max = sum;
        int left = 2;
        int right = X + 1;
        int cnt = 1;

        while (right <= N) {
            sum = sum + arr[right] - arr[left - 1];
            if (max == sum) ++cnt;
            else if (max < sum) {
                max = sum;
                cnt = 1;
            }
            ++left;
            ++right;
            System.out.println("sum " + sum);
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
