import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수_4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] arr;
    static int w = 1, h = 1;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        while (true) {
            inputs();
            if (w == 0 && h == 0) break;
            solution();
        }
        System.out.println(sb.toString());
    }

    private static void solution() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                    ++ans;
                }
            }
        }
        sb.append(ans).append('\n');
    }

    private static void dfs(int y, int x) {
        if (searchException(y, x)) return;

        visited[y][x] = true;

        Code[] moves = {new Code(-1, -1), new Code(-1, 0), new Code(-1, 1), new Code(0, -1), new Code(0, 1), new Code(1, -1), new Code(1, 0), new Code(1, 1)};

        for (Code c : moves) {
            dfs(c.y + y, c.x + x);
        }
    }

    private static boolean searchException(int y, int x) {
        if (y < 0 || x < 0 || y >= h || x >= w) return true;
        if (visited[y][x] || arr[y][x] == 0) return true;

        return false;

    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        visited = new boolean[h][w];
        arr = new int[h][w];
        ans = 0;
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Code {
        int y;
        int x;

        public Code(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

