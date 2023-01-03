import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리와쿼리_15681 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, Q, R;
    static ArrayList<Integer>[] list;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() throws IOException {
        dfs(R, -1);
        for (int i = 1; i <= Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(ans[q]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int n, int prev) {
        ans[n] = 1;
        for (int x : list[n]) {
            if (x == prev) continue;
            dfs(x, n);
            ans[n] += ans[x];
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        ans = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }
}



