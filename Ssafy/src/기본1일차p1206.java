import java.util.ArrayList;
import java.util.Scanner;

public class 기본1일차p1206 {

    static int width;
    static int[] towers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;
        for (int i = 1; i <= T; i++) {
            long sum = 0;
            width = sc.nextInt();
            towers = new int[width];

            for (int j = 0; j < width; j++) {
                towers[j] = sc.nextInt();
            }

            for (int j = 2; j < width - 2; j++) {
                int max = Math.max(Math.max(towers[j - 2], towers[j - 1]), Math.max(towers[j + 1], towers[j + 2]));

                if (towers[j] - max > 0) {
                    sum += towers[j] - max;
                }
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}

