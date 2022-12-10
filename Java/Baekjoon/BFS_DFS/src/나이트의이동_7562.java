import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static int N;
    static int[][] arr;
    static int[][] visited;
    static int x, y;
    static int nx, ny;
    static int[][] move = {
            {1, -2}, {2, -1}, {2, 1}, {1, 2},
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
    };

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            inputs();
            solution(y, x);
        }
        System.out.println(sb.toString());
    }

    private static void solution(int yy, int xx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(yy);
        q.add(xx);
        visited[yy][xx] = 0;

        while (!q.isEmpty()) {
            yy = q.poll();
            xx = q.poll();

            for (int i = 0; i < move.length; i++) {
                int nyy = yy + move[i][0];
                int nxx = xx + move[i][1];

                if (bfsException(nyy, nxx)) continue;
                q.add(nyy);
                q.add(nxx);
                visited[nyy][nxx] = visited[yy][xx] + 1;
            }
        }
        sb.append(visited[ny][nx]).append('\n');
    }

    private static boolean bfsException(int yy, int xx) {
        if (yy < 0 || xx < 0 || yy >= N || xx >= N) return true;
        return visited[yy][xx] != Integer.MAX_VALUE;
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new int[N][N];
        st = new StringTokenizer(br.readLine());
        ny = Integer.parseInt(st.nextToken());
        nx = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++)
            Arrays.fill(visited[i], Integer.MAX_VALUE);
    }
}
