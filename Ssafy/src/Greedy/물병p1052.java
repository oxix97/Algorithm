package Greedy;

import java.util.*;

public class 물병p1052 {
    static Scanner sc = new Scanner(System.in);
    static int totalCnt = 0;

    public static void main(String[] args) {
        int N = sc.nextInt();
        int K = sc.nextInt();
        //K가 1의 개수
        while (true) {
            char[] binary = Integer.toBinaryString(N).toCharArray();
            int cnt = 0;

            for (char c : binary) {
                if (c == '1') ++cnt;
            }

            if (cnt <= K)
                break;

            N++;
            totalCnt++;
        }
        System.out.println(totalCnt);
    }
}
