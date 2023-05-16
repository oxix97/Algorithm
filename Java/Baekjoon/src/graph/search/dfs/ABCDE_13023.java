package src.graph.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
            arr[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from].add(to);
            arr[to].add(from);
        }
    }

    private static void solution() {
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
        }
        System.out.println(0);
    }

    private static void dfs(int n, int cnt) {
        if (cnt == 5) {
            System.out.println(1);
            System.exit(0);
        }

        if (visited[n]) return;

        visited[n] = true;

        for (int x : arr[n]) {
            if (!visited[x]) {
                dfs(x, cnt + 1);
            }
        }
        visited[n] = false;
    }

    private static void output() {
        System.out.print(sb);
    }
}
