package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] arr;
    static int[][] move = {{1, 1}, {1, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        arr = new int[20][20];
        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isBreak = false;
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (arr[j][i] == 0) continue;
                if (recursion(j, i, arr[j][i])) {
                    sb.append(arr[j][i]).append('\n');
                    sb.append(j).append(' ').append(i);
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) break;
        }

        if (!isBreak) sb.append(0);
        System.out.println(sb);
        br.close();
    }

    private static boolean recursion(int y, int x, int v) {
        for (int[] next : move) {
            int cnt = 1;
            int ny = y + next[0];
            int nx = x + next[1];
            while (rangeException(ny, nx) && arr[ny][nx] == v) {
                ny += next[0];
                nx += next[1];
                ++cnt;
            }
            ny = y - next[0];
            nx = x - next[1];
            while (rangeException(ny, nx) && arr[ny][nx] == v) {
                ny -= next[0];
                nx -= next[1];
                ++cnt;
            }
            if (cnt == 5) {
                return true;
            }
        }
        return false;
    }

    private static boolean rangeException(int y, int x) {
        return y >= 1 && x >= 1 && y <= 19 && x <= 19;
    }
}
