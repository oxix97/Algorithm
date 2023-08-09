package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solved_ac_18110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // N : 의견 개수, arr : 의견, 입력값 받은 후 정렬
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // TOP : 위의 15%, BOTTOM : 아래 15% 몇명인지 구하기  / (소수 반올림)
        int limit = (int) Math.round(N * 0.15);

        // TOP, BOTTOM에 해당 되는 값을 제외하고 전부 더함
        int sum = 0;
        for (int i = limit; i < N - limit; i++) {
            sum += arr[i];
        }

        // sum / N-(TOP+BOTTOM)
        int answer = Math.round((float) sum / (N - (limit * 2)));
        System.out.println(answer);
        br.close();
    }
}
