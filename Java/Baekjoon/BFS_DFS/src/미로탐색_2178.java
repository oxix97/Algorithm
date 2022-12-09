import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] maze;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        bfs(1, 1);
        System.out.println(dist[N][M]);
    }

    private static void bfs(int y, int x) {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        dist[y][x] = 1;

        while (!q.isEmpty()) {
            y = q.poll();
            x = q.poll();

            for (int i = 1; i <= 4; i++) {
                int ny = y + dir[i - 1][0];
                int nx = x + dir[i - 1][1];
                if (bfsException(ny, nx)) continue;

                q.add(ny);
                q.add(nx);
                dist[ny][nx] = dist[y][x] + 1;
            }
        }
    }

    private static boolean bfsException(int y, int x) {
        if (y < 0 || x < 0 || y > N || x > M) return true;
        return dist[y][x] != -1 || maze[y][x] == 0;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char[] lines = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = Character.getNumericValue(lines[j - 1]);
            }
        }
    }
}
