package ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기_1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    //가지고 있는 랜선 K, 필요한 랜선 개수 N
    static int N, K;
    static int[] arr;
    static int avg;

    public static void main(String[] args) throws IOException {
        inputs();
        recursion();
    }

    private static void recursion() {
        long L = 1, R = avg, ans = 0;
        while (L <= R) {
            int mid = (int) ((L + R) / 2);
            if (check(mid)) {
                L = mid + 1;
                ans = mid;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean check(int mid) {
        long cnt = 0;
        for (int i = 1; i <= K; i++) {
            cnt += arr[i] / mid;
        }
        return cnt >= N;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long sum = 0;
        arr = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        avg = (int) (sum / K);
    }
}
