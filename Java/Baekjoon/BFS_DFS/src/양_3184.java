import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양_3184 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C;
    static char[][] arr;
    static boolean[][] visited;
    static int o, v;
    static int[] result = {0, 0};

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && arr[i][j] != '#') {
                    dfs(i, j);
                    fight(o, v);
                    o = 0;
                    v = 0;
                }
            }
        }
        sb.append(result[0]).append(' ').append(result[1]);
    }

    private static void fight(int o, int v) {
        if (o > v) {
            result[0] += o;
        } else {
            result[1] += v;
        }
    }

    private static void dfs(int y, int x) {
        if (dfsException(y, x)) return;

        visited[y][x] = true;

        if (arr[y][x] == 'v') v++;
        else if (arr[y][x] == 'o') o++;

        dfs(y + 1, x);
        dfs(y - 1, x);
        dfs(y, x - 1);
        dfs(y, x + 1);
    }

    private static boolean dfsException(int y, int x) {
        if (y < 0 || x < 0 || y >= R || x >= C) return true;
        if (visited[y][x] || arr[y][x] == '#') return true;
        return false;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
    }
}
