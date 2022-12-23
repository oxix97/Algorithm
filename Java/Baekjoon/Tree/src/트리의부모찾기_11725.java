import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] list;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        dfs(1, -1);
        for (int i = 2; i <= N; i++)
            sb.append(ans[i]).append('\n');
        System.out.print(sb);
    }

    private static void dfs(int n, int par) {
        for (int item : list[n]) {
            if (item == par) continue;
            ans[item] = n;
            dfs(item, n);
        }
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        ans = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }
}
