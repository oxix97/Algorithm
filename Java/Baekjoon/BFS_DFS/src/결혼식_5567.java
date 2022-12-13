import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식_5567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>(list[1]);
        visited[1] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int n = q.poll();
            for (int i : list[n]) {
                if (visited[i]) continue;
                visited[i] = true;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

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
