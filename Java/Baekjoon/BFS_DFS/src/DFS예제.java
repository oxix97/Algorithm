import java.util.Arrays;

public class DFS예제 {
    static int[][] graph = {
            {},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}
    };
    static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[graph.length];
        Arrays.fill(visited, false);
        dfs(graph, visited, 1);
    }

    public static void dfs(int[][] graph, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i : graph[v]) {
            if (!visited[i])
                dfs(graph, visited, i);
        }
    }
}
