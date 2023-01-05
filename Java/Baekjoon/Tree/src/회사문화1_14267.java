import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회사문화1_14267 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static ArrayList<Integer>[] list;
    static int[] ans;
    static int[] points;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        visited = new boolean[n + 1];
        bfs(1);
        for (int i = 1; i <= n; i++) {
            sb.append(points[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int v : list[x]) {
                if (visited[v]) continue;
                q.add(v);
                points[v] += points[x];
                visited[v] = true;
            }
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = new int[n + 1];
        list = new ArrayList[n + 1];
        points = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx == -1) continue;
            list[idx].add(i);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            points[a] += b;
        }
    }
}
