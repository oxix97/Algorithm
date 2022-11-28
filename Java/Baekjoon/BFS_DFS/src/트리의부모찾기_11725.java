import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static ArrayList<Integer>[] list;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        for (int i = 1; i < T; i++) {
            if (!visited[i]) {
                System.out.println("-----------------");
                dfs(i);
            }
        }
        for (int i = 2; i <= T; i++) {
            sb.append(parents[i]).append('\n');
        }
    }

    private static void dfs(int n) {
        if (visited[n]) return;

        visited[n] = true;

        for (int i : list[n]) {
            if (!visited[i]) {
                parents[i] = n;
                System.out.println("parents["+i+"] = "+parents[i]);
                dfs(i);
            }
        }
    }

    private static void inputs() throws IOException {
        T = Integer.parseInt(br.readLine());
        list = new ArrayList[T + 1];
        parents = new int[T + 1];
        visited = new boolean[T + 1];

        for (int i = 1; i <= T; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list[n].add(m);
            list[m].add(n);
        }

        Arrays.fill(visited, false);
        Arrays.fill(parents, 0);
    }
}
