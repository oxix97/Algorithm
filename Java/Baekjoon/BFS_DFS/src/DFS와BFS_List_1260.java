import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS_List_1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        dfs(V);
        sb.append('\n');
        Arrays.fill(visited, false);
        bfs(V);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        sb.append(v).append(' ');

        while (!q.isEmpty()) {
            int item = q.poll();
            for (int i : list[item]) {
                if (!visited[i]) {
                    sb.append(i).append(' ');
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');
        for (int i : list[v]) {
            if (!visited[i])
                dfs(i);
        }
    }


    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(visited, false);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list[n].add(m);
            list[m].add(n);
        }
    }

}
