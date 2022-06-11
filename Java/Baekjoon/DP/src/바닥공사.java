import java.util.Arrays;
import java.util.Scanner;

public class 바닥공사 {
    static Scanner sc = new Scanner(System.in);
    static int[] arr;

    public static void main(String[] args) {
        int N = sc.nextInt();
        arr = new int[1001];
        Arrays.fill(arr, 0);
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 3;

        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 1] + (arr[i - 2] * 2)) % 796796;
        }

        System.out.println(arr[N]);
    }
}
