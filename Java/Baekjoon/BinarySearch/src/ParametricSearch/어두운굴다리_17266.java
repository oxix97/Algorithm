package ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 어두운굴다리_17266 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        outputs();
        System.out.println(sb.toString());
    }

    private static void outputs() {
        int L = 1, R = N, ans = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (check(mid)) {
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }
        sb.append(ans);
    }

    private static boolean check(int height) {
        int pre = 0;
        for (int i = 1; i <= M; i++) {
            if (arr[i] - height > pre) {
                //높이가 부족함
                return false;
            }
            pre = arr[i] + height;
        }
        return N - pre <= 0;
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine()); // 굴다리 길이
        M = Integer.parseInt(br.readLine()); // 주어진 가로등 개수
        arr = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
