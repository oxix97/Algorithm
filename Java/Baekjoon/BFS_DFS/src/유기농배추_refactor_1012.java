import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_refactor_1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static int M, N, K;
    static int[][] field;
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            inputs();
            solution();
            sb.append(cnt).append('\n');
            cnt = 0;
        }
        System.out.println(sb.toString());
    }

    private static void solution() {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (!visited[j][k] && field[j][k] == 1) {
                    dfs(k, j);
                    ++cnt;
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        if (dfsException(x, y)) return;

        visited[y][x] = true;

        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);

    }

    private static boolean dfsException(int x, int y) {
        if (x < 0 || y < 0 || x >= M || y >= N)
            return true;

        if (visited[y][x] || field[y][x] == 0) return true;

        return false;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            field[n][m]++;
        }
    }
}
