import java.util.Arrays;
import java.util.Scanner;

public class _2n타일링_11726 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        N = sc.nextInt();
        arr = new int[1001];
        Arrays.fill(arr, 0);
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= N; i++) {
            if (arr[i] != 0)
                continue;
            arr[i] = ((arr[i - 1] + arr[i - 2]) % 10007);
        }
        System.out.println(arr[N]);
    }
}
