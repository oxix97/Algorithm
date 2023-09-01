package src.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] room;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        //input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        벽 세우기
        makeWall(3);

        System.out.println(answer);
        br.close();
    }

    private static void makeWall(int cnt) {
        if (cnt == 0) {
            spread();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || room[i][j] != 0) continue;
                visited[i][j] = true;
                room[i][j] = 1;
                makeWall(cnt - 1);
                visited[i][j] = false;
                room[i][j] = 0;
            }
        }
    }

    private static void spread() {
        int[][] arr = new int[N][M];
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = room[i][j];
                if (arr[i][j] == 2) {
                    q.add(i);
                    q.add(j);
                }
            }
        }

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int[] next : move) {
                int ny = y + next[0];
                int nx = x + next[1];
                if (exceptionRange(ny, nx)) continue;
                if (arr[ny][nx] != 0) continue;
                arr[ny][nx] = 2;
                q.add(ny);
                q.add(nx);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) ++cnt;
            }
        }

        answer = Math.max(cnt, answer);
    }

    private static boolean exceptionRange(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= M;
    }
}
