package src.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static char[][] arr;
    static boolean[][] visited;
    static final int[][] MOVE = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            arr[i] = line;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                normalDfs(i, j);
                ++cnt;
            }
        }
        sb.append(cnt).append(' ');

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                abNormalDfs(i, j);
                ++cnt;
            }
        }
        sb.append(cnt);

        System.out.println(sb.toString());
        br.close();
    }

    private static boolean rangeException(int y, int x) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    private static void normalDfs(int y, int x) {
        visited[y][x] = true;

        for (int[] move : MOVE) {
            int ny = y + move[0];
            int nx = x + move[1];
            if (rangeException(ny, nx)) continue;
            if (visited[ny][nx]) continue;
            if (arr[y][x] != arr[ny][nx]) continue;
            normalDfs(ny, nx);
        }
    }

    private static void abNormalDfs(int y, int x) {
        visited[y][x] = true;

        for (int[] move : MOVE) {
            int ny = y + move[0];
            int nx = x + move[1];
            if (rangeException(ny, nx)) continue;
            if (visited[ny][nx]) continue;
            if (arr[y][x] == 'B' && arr[ny][nx] != 'B') continue;
            if (arr[y][x] != 'B' && arr[ny][nx] == 'B') continue;
            abNormalDfs(ny, nx);
        }
    }
}
