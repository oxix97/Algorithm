package ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산_2512 {
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
        long L = 1, R = M, ans = 0;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (check(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        if (ans == M) ans = arr[N];
        System.out.println(ans);
    }

    private static boolean check(long n) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if (n > arr[i]) {
                sum += arr[i];
            } else {
                sum += n;
            }
        }
        return sum <= M;
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
    }
}
