import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장가까운공통조상_3584 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> pickup;
    static int T, N;
    static boolean[] visited;
    static int c1, c2;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            inputs();
            solution();
        }
        System.out.print(sb);
    }

    private static void solution() {
        dfs(c1);
        ArrayList<Integer> r1 = new ArrayList<>(pickup);
        pickup.clear();
        Arrays.fill(visited, false);
        dfs(c2);
        ArrayList<Integer> r2 = new ArrayList<>(pickup);
        for (int i = 0; i < Math.min(r1.size(), r2.size()); i++) {
            if (r1.get(i).equals(r2.get(i))) {
                sb.append(r1.get(i)).append('\n');
                return;
            }
        }
    }

    private static void dfs(int n) {
        visited[n] = true;
        pickup.add(n);
        for (int i : list[n]) {
            if (visited[i]) continue;
            dfs(i);
        }
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        pickup = new ArrayList<>();
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
    }
}
