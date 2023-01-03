import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리와쿼리_15681 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, R, Q;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] newList;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        createdTree();

        for (int i = 0; i < Q; i++) {
            result = 0;
            Arrays.fill(visited, false);
            dfs(arr[i]);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    private static void createdTree() {
        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(R);
        ans[R] = -1;

        while (!q.isEmpty()) {
            int n = q.poll();
            for (int x : list[n]) {
                if (ans[x] != 0) continue;
                newList[n].add(x);
                ans[x] = n;
                q.add(x);
            }
        }
    }

    private static void dfs(int n) {
        visited[n] = true;
        ++result;
        for (int x : newList[n]) {
            if (!visited[x]) {
                dfs(x);
            }
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        newList = new ArrayList[N + 1];
        arr = new int[Q];
        ans = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            newList[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < Q; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}
