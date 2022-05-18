import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 백만장자프로젝트p1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            long diff = 0;
            int max_value = 0;
            int[] arr = new int[n];

            //여기서 아이템 받아
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            //거꾸로 간다 ->
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] > max_value)
                    max_value = arr[j];
                diff += max_value - arr[j];
            }
            System.out.printf("#%d %d\n", i + 1, diff);
        }
        sc.close();
    }
}
