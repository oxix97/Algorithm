package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 기타줄p1049 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();

        int packageCnt = N / 6;
        int pieceCnt = N % 6;
        int[] packageShop = new int[M];
        int[] pieceShop = new int[M];

        for (int i = 0; i < M; i++) {
            packageShop[i] = sc.nextInt();
            pieceShop[i] = sc.nextInt();
        }

        Arrays.sort(packageShop);
        Arrays.sort(pieceShop);

        int case1 = (packageShop[0] * packageCnt) + (pieceShop[0] * pieceCnt);
        int case2 = pieceShop[0] * N;
        int case3 = packageShop[0] * (packageCnt + 1);

        int min = setMinValue(case1, case2, case3);

        System.out.println(min);
    }

    public static int setMinValue(int q1, int q2, int q3) {
        int temp1 = Math.min(q1, q2);
        return Math.min(temp1, q3);
    }
}
