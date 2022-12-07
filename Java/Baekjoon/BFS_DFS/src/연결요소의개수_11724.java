import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int N, M;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                ++ans;
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int n) {
        visited[n] = true;

        for (int i : list[n]) {
            if (!visited[i])
                dfs(i);
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }
    }
}
