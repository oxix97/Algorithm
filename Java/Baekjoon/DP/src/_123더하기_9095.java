import java.util.Arrays;
import java.util.Scanner;

public class _123더하기_9095 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        int[] arr = new int[12];
        Arrays.fill(arr, 0);
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int j = 1; j <= T; j++) {
            int N = sc.nextInt();
            for (int i = 4; i <= N; i++)
                arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];

            System.out.println(arr[N]);
        }
    }
}
