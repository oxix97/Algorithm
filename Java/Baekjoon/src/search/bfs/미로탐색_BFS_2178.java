package src.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_BFS_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static final int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //상하좌우

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = input[j] - '0';
            }
        }
    }

    private static void solution() {
        bfs(0, 0);
    }

    private static void bfs(int n, int m) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        q.add(m);
        visited[n][m] = true;

        while (!q.isEmpty()) {
            int nx = q.poll();
            int ny = q.poll();

            for (int[] idx : move) {
                int ix = idx[0] + nx;
                int iy = idx[1] + ny;

                if (checkExceptions(ix, iy)) continue;

                q.add(ix);
                q.add(iy);

                visited[ix][iy] = true;
                maze[ix][iy] = maze[nx][ny] + 1;
            }
        }
    }

    private static boolean checkExceptions(int ix, int iy) {
        if (ix < 0 || iy < 0 || ix >= N || iy >= M) return true;
        else if (maze[ix][iy] == 0) return true;
        else if (visited[ix][iy]) return true;

        return false;
    }

    private static void output() {
        System.out.println(maze[N - 1][M - 1]);
    }
}
