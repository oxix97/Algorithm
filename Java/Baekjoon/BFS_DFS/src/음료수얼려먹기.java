import java.util.Scanner;

public class 음료수얼려먹기 {
    static int[][] graph;
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        inputGraph();
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    ++result;
                }
            }
        }
    }

    private static boolean dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false;

        //방문하지 않은 얼음
        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    private static void inputGraph() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
    }
}
