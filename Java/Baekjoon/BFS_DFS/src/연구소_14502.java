import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연구소_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static int[][] tmp;
    static boolean[][] visited;
    static boolean[][] visitedVirus;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    dfs(i, j, 0);
                    printMap();
                    arr = tmp;
                }
            }
        }
        System.out.println(answer);
    }

    private static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int y, int x, int cnt) {
        if (cnt == 3) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(visitedVirus[i], false);
            }
            spreadVirus();
            int result = countSafeArea();
            answer = Math.max(answer, result);
            return;
        }

        if (dfsException(y, x, cnt)) return;

        visited[y][x] = true;
        arr[y][x] = 1;

        dfs(y + 1, x, cnt + 1);
        dfs(y - 1, x, cnt + 1);
        dfs(y, x + 1, cnt + 1);
        dfs(y, x - 1, cnt + 1);
    }

    private static int countSafeArea() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) ++cnt;
            }
        }

        return cnt;
    }

    private static boolean dfsException(int y, int x, int cnt) {
        if (y < 0 || x < 0 || y >= N || x >= M) return true;
        if (visited[y][x]) return true;
        if (arr[y][x] != 0 && cnt < 3) {
            dfs(y + 1, x, cnt+1);
            dfs(y - 1, x, cnt+1);
            dfs(y, x + 1, cnt+1);
            dfs(y, x - 1, cnt+1);
            return true;
        }

        return false;
    }

    private static void spreadVirus() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2 && !visitedVirus[i][j])
                    dfsVirus(i, j);
            }
        }

        int result = countSafeArea();
    }

    private static boolean virusException(int y, int x) {
        if (y < 0 || x < 0 || y >= N || x >= M) return true;
        if (arr[y][x] == 1 || visitedVirus[y][x]) return true;
        return false;
    }

    private static void dfsVirus(int y, int x) {
        if (virusException(y, x)) return;

        visitedVirus[y][x] = true;
        arr[y][x] = 2;

        dfsVirus(y + 1, x);
        dfsVirus(y - 1, x);
        dfsVirus(y, x + 1);
        dfsVirus(y, x - 1);
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        tmp = new int[N][M];
        visited = new boolean[N][M];
        visitedVirus = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tmp[i][j] = arr[i][j];
            }
            Arrays.fill(visited[i], false);
            Arrays.fill(visitedVirus[i], false);
        }
    }
}
