import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트_18111 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, B;
    static int[][] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        int ansTime = Integer.MAX_VALUE, ansHeight = 0;
        for (int h = min; h <= max; h++) {
            int time = 0; //걸린 시간
            int item = B;
            int digging = 0;
            int building = 0;
            //높이에 맞춰서 땅을 파는 작업
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (arr[i][j] > h) {
                        time += (arr[i][j] - h) * 2;
                        item += (arr[i][j] - h);
                        ++digging;
                    }
                }
            }
            //높이에 맞춰서 땅을 매꾸는 작업 ->
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (arr[i][j] < h) {
                        time += (h - arr[i][j]);
                        item -= (h - arr[i][j]);
                        ++building;
                    }
                }
            }
            //땅을 인벤토리에 있는 것 이상으로 사용한 경우 제외하기 위해서 제한시간을 최대로 잡음
            if (item < 0) {
                time = Integer.MAX_VALUE;
            }
            if (ansTime >= time) {
                ansTime = time;
                ansHeight = Math.max(h, ansHeight);
            }
        }
        sb.append(ansTime).append(' ').append(ansHeight);
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }
    }
}
