package ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int N, M; // 강의의 수 N, 블루레이 수 M
    static int L, R;

    public static void main(String[] args) throws IOException {
        inputs();
        recursion();
    }


    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            R += arr[i];
            L = Math.max(L, arr[i]);
        }
    }

    private static void recursion() {
        //L -> arr 가장 큰값 , R -> arr 배열의 합
        while (L <= R) {
            int mid = (L + R) / 2;
            //
            if (check(mid) > M) {
                //용량을 작게 잡았다.
                L = mid + 1;
            } else {
                //용량을 크게 잡았다.
                R = mid - 1;
            }
        }
        System.out.println(L);
    }

    private static int check(int mid) {
        long sum = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (sum + arr[i] > mid) {
                sum = 0;
                ++cnt;
            }
            sum += arr[i];
        }
        if (sum != 0) ++cnt;
        return cnt;
    }
}
