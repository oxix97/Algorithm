package ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용돈관리_6236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int sum = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        outputs();
        System.out.println(sb.toString());
    }

    private static void outputs() {
        int L = max, R = sum, K = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (M >= check(mid)) {
                //돈 출금을 M번 하거나 밑으로 한 경우 -> 돈이 많음, 인출 횟수가 작음
                K = mid;
                R = mid - 1;
            } else {
                //돈 출금 M번 이상으로 한 경우 -> 돈이 부족 함 , 인출 횟수가 많음
                L = mid + 1;
            }
        }
        sb.append(K);
    }

    private static int check(int amount) {
        int money = amount;
        int cnt = 1;
        for (int i = 1; i <= N; i++) {
            money -= arr[i];
            if (money < 0) {
                //돈이 부족한 경우
                cnt++;
                money = amount - arr[i];
            }
        }
        //돈 인출한 횟수가 정해진 횟수보다 많은 경우
        return cnt;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
    }
}
