import java.util.Arrays;
import java.util.Scanner;

public class _1로만들기 {
    static Scanner sc = new Scanner(System.in);
    static int[] arr = new int[30001];
    static int cnt = 1;

    public static void main(String[] args) {
        int N = sc.nextInt();
        Arrays.fill(arr, 0);

        dp(N);
        System.out.println(cnt);
    }

    private static void dp(int n) {
        if (n <= 1) return;
        if (arr[n] != 0) return;
        ++cnt;

        arr[n] = n;
        arr[n - 1] = n - 1;

        dp(n - 1);

        if (n % 2 == 0) {
            dp(n / 2);
        }
        if (n % 3 == 0) {
            dp(n / 3);
        }
        if (n % 5 == 0) {
            dp(n / 5);
        }

    }
}
