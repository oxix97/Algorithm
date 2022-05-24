package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DFSandBFS_1261 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String edge = br.readLine();
            int node1 = Integer.parseInt(edge.split(" ")[0]);
            int node2 = Integer.parseInt(edge.split(" ")[1]);

            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(map.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void bfs(int V) {
        ArrayList<Integer> visitedList = new ArrayList<>();
        ArrayList<Integer> needVisit = new ArrayList<>();

        needVisit.add(V);

        while (needVisit.size() > 0) {
            int node = needVisit.remove(0);
            if (!visitedList.contains(node)) {
                visitedList.add(node);
                needVisit.addAll(map.get(node));
            }
        }

        for (int i : visitedList) {
            System.out.print(i + " ");
        }
    }

    private static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");
        for (int node : map.get(V)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}
