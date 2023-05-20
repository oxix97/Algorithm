package src.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 최빈수구하기_1204 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] points = new int[101];
            for (int i = 1; i <= 1000; i++) {
                int score = sc.nextInt();
                ++points[score];
            }

            int max = points[0];
            int answer = 0;
            for (int i = 0; i <= 100; i++) {
                if (max <= points[i]) {
                    max = points[i];
                    answer = i;
                }
            }
            System.out.println("#" + n + " " + answer);
        }

        br.close();
    }
}
