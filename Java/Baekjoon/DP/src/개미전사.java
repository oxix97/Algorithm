import java.util.Scanner;

public class 개미전사 {
    static Scanner sc = new Scanner(System.in);
    static int[] arr;
    static int sum = 0;

    public static void main(String[] args) {
        int N = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        dp(N);
        System.out.println(sum);
    }

    private static void dp(int n) {
        if (n <= 2) return;
        if (arr[n] + arr[n - 2] > arr[n - 1]) {
            sum += (arr[n] + arr[n - 2]);
            dp(n - 2);
        } else {
            sum += arr[n - 1];
            dp(n - 1);
        }
    }
}
