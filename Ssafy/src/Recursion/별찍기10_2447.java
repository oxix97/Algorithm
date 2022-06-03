package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class 별찍기10_2447 {
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new char[N][N];

        for (char[] value : arr) {
            Arrays.fill(value, ' ');
        }

        solution(0, 0, N);

        for (char[] chars : arr) {
            System.out.println(chars);
        }
    }

    public static void solution(int x, int y, int n) {
        int cnt = 0;
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        cnt = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                solution(x + (cnt * i), y + (cnt * j), cnt);
            }
        }
    }
}
