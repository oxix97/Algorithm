package ssafy_test;

import java.util.Scanner;

public class Test1 {
    static Scanner sc = new Scanner(System.in);
    static int T;

    public static void main(String[] args) {
        T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            int sum = 0;

            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    int temp = (arr[j] % arr[k]);
                    System.out.println("arr i/j = "+temp);
                    System.out.println(temp);
                    sum += temp;
                }
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}