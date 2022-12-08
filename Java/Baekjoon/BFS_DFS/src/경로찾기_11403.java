import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 경로찾기_11403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        for (int i = 0; i < N; i++) {
            if (list[i].isEmpty())
                continue;
            bfs(i);
        }
        printResult();
    }

    private static void bfs(int n) {
        boolean[] tmp = new boolean[N];
        Queue<Integer> q = new LinkedList<>(list[n]);
        while (!q.isEmpty()) {
            int item = q.poll();
            tmp[item] = true;

            for (int i = 0; i < list[item].size(); i++) {
                int num = list[item].get(i);
                if (!tmp[num]) {
                    q.add(num);
                    tmp[num] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (tmp[i]) {
                visited[n][i] = true;
            }
        }
    }

    private static void printResult() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j])
                    sb.append('1');
                else
                    sb.append('0');
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    list[i].add(j);
                }
            }
        }
    }
}
