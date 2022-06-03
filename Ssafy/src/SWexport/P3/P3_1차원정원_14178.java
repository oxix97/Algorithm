package SWexport.P3;

import java.util.Scanner;

public class P3_1차원정원_14178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            double result = (double) N / ((2 * D) + 1);
            System.out.println("#" + i + " " + (int) (Math.ceil(result)));
        }
    }
}
