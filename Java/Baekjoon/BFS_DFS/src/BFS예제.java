import java.util.*;

public class BFS예제 {

    static int[][] graph = {{}, {2, 3, 8}, {1, 7}, {1, 4, 5}, {3, 5}, {3, 4}, {7}, {2, 6, 8}, {1, 7}};
    static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[graph.length];
        Arrays.fill(visited, false);
        bfs(graph, visited, 1);
    }

    private static void bfs(int[][] graph, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");

            for (int i : graph[v]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }


}
