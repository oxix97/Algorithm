import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }


        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                dfs(i);
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int v) {
        if (visited[v]) return;
        visited[v] = true;

        for (int i : list[v]) {
            if (!visited[i]) {
                parents[i] = v;
                dfs(i);
            }
        }
    }
}
