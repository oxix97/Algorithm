package ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        recursion();
    }

    private static void recursion() {
        long L = 0, R = 2000000000, result = 0;
        while (L <= R) {
            int mid = (int) ((L + R) / 2);
            if (check(mid)) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int height) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] > height) {
                sum += arr[i] - height;
            }
        }
        return sum >= M;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
