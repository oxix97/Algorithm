package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares_17626 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int answer = 4;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.sqrt(N)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.pow(i + 1, 2);
        }

        dfs(0, 0);

        System.out.println(answer);
        br.close();
    }

    private static void dfs(int now, int cnt) {
        if (now == N) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (cnt == 3) return;

        for (int i : arr) {
            dfs(now + i, cnt + 1);
        }
    }
}
