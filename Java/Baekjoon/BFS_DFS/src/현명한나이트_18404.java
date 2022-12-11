import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 현명한나이트_18404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, X, Y;
    static int[][] arr;
    static int[][] move = {
            {1, -2}, {2, -1}, {2, 1}, {1, 2},
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
    };
    static Target[] targets;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        bfs(X, Y);
        output();
    }

    private static void output() {
        for (int i = 0; i < M; i++) {
            sb.append(arr[targets[i].x][targets[i].y]).append(' ');
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        arr[x][y] = 0;

        while (!q.isEmpty()) {
            x = q.poll();
            y = q.poll();

            for (int i = 0; i < move.length; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];

                if (bfsException(nx, ny)) continue;

                q.add(nx);
                q.add(ny);
                arr[nx][ny] = arr[x][y] + 1;
            }
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //판 크기
        M = Integer.parseInt(st.nextToken()); // 반복 회수

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()); // 나이트 위치 x
        Y = Integer.parseInt(st.nextToken()); // 나이트 위치 y

        targets = new Target[M];
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = -1;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            targets[i] = new Target(x, y);
        }
    }

    static boolean bfsException(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx > N || ny > N) return true;
        return arr[nx][ny] != -1;
    }

    static class Target {
        int x;
        int y;

        public Target(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
