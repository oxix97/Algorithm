package ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int C, N; // 집 C, 공유기 N
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        recursion();
        System.out.println(sb.toString());
    }

    private static void recursion() {
        int L = 1, R = arr[C], ans = 0;
        while (L <= R) {
            int mid = (L + R) / 2; // 최소거리 1 , 최대거리 arr[C] 중간이 mid
            if (check(mid)) {
                // 공유기를 N개 이상으로 배정 또는 알맞게 배정 -> 거리가 넓혀야한다. 알맞게 배정시 최대한 넓히기 위하여 같은작업
                ans = mid;
                L = mid + 1;
            } else {  //공유기를 다 못놓음 -> 거리가 멀다.
                R = mid - 1;
            }
        }
        sb.append(ans);
    }

    private static boolean check(long distance) {
        int cnt = 1;
        long lastIndex = arr[1]; // 마지막으로 공유기 설치한 위치, 처음 시작할땐 무조건 공유기 처음에 설치하고 시작
        for (int i = 2; i <= C; i++) {
            if (arr[i] - lastIndex < distance) continue;

            //직전의 설치한 공유기끼리의 위치가 최소거리 보다 큰 경우 횟수 추가, 마지막 위치 갱신
            cnt++;
            lastIndex = arr[i];
        }
        return cnt >= N;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[C + 1];
        for (int i = 1; i <= C; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
    }
}
