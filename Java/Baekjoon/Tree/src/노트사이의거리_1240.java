import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 노트사이의거리_1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Edge>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() throws IOException {
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(bfs(x, y)).append('\n');
        }
        System.out.print(sb);
    }

    private static int bfs(int start, int end) {
        Queue<Edge> q = new LinkedList<>();
        visited = new boolean[N + 1];
        q.add(new Edge(start, 0));
        visited[start] = true;
        int dist = 0;

        while (!q.isEmpty()) {
            Edge edge = q.poll();
            if (edge.start == end) {
                dist = edge.end;
                break;
            }

            for (Edge e : tree[edge.start]) {
                if (visited[e.start]) continue;
                visited[e.start] = true;
                q.add(new Edge(e.start, e.end + edge.end));
            }
        }
        return dist;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++)
            tree[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            tree[start].add(new Edge(end, distance));
            tree[end].add(new Edge(start, distance));

        }
    }

    static class Edge {
        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
