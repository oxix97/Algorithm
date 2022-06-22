import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리 {
    static int[][] arr;
    static int[][] ans;
    static int N;
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[1001][3];
        ans = new int[1001][3];
        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(ans[i], 0);
        }

        ans[0][RED] = arr[0][RED];
        ans[0][GREEN] = arr[0][GREEN];
        ans[0][BLUE] = arr[0][BLUE];

        System.out.println(Math.min(recursion(N - 1, RED), Math.min(recursion(N - 1, GREEN), recursion(N - 1, BLUE))));
    }

    private static int recursion(int n, int color) {
        if (ans[n][color] != 0) return ans[n][color];

        if (color == RED) {
            ans[n][color] = Math.min(recursion(n - 1, GREEN), recursion(n - 1, BLUE)) + arr[n][color];
        } else if (color == GREEN) {
            ans[n][color] = Math.min(recursion(n - 1, RED), recursion(n - 1, BLUE)) + arr[n][color];
        } else {
            ans[n][color] = Math.min(recursion(n - 1, RED), recursion(n - 1, GREEN)) + arr[n][color];
        }

        return ans[n][color];

    }

}
