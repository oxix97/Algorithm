package src.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기_18352 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K, X; // 노드개수, 에지 개수, 최단 거리, 출발 노드
    static int[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    @SuppressWarnings({"DuplicatedCode", "unchecked"})
    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        Arrays.fill(visited, -1);

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
        }
    }

    private static void solution() {
        bfs(X);
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int nx : list[x]) {
                if (visited[nx] == -1) {
                    q.add(nx);
                    visited[nx] = visited[x] + 1;
                }
            }
        }
    }

    private static void output() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                appendVertical(i);
                ++cnt;
            }
        }
        if (cnt == 0)
            appendVertical(-1);

        System.out.print(sb.toString());
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }
}
