import java.util.Arrays;
import java.util.Scanner;

public class 위에서아래로 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) {
        N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}
