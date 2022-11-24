import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 단지번호붙이기_2667 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int cnt = 0;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb);
    }

    private static void solution() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for (int i : list)
            sb.append(i).append('\n');
    }

    private static boolean dfsException(int x, int y) {

        if (x < 0 || y < 0) return true;

        if (x >= N || y >= N) return true;

        if (arr[x][y] == 0) {
            return true;
        }

        if (visited[x][y]) return true;

        return false;
    }

    private static void dfs(int x, int y) {
        if (dfsException(x, y)) return;

        visited[x][y] = true;
        ++cnt;

        dfs(x - 1, y); //위
        dfs(x + 1, y); // 아래
        dfs(x, y - 1); // 왼
        dfs(x, y + 1); //오
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str[j]));
            }
            Arrays.fill(visited[i], false);
        }
    }
}
