package src.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인해킹_1325 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M; // 컴퓨터 수(노드) / 관계 수 (간선)
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        br.close();
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        answer = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }
    }

    private static void solution() {
        int max = 0;
        for (int i = 1; i <= N; i++) {
            dfs(i);
            Arrays.fill(visited, false);
        }

        for (int i = 1; i <= N; i++) {
            if (max > answer[i]) continue;
            max = answer[i];
        }
        output(max);
    }

    private static void dfs(int n) {
        visited[n] = true;

        for (int nx : list[n]) {
            if (!visited[nx]) {
                dfs(nx);
                answer[nx]++;
            }
        }
    }

    private static void output(int max) {
        for (int i = 1; i <= N; i++) {
            if (max == answer[i]) appendHorizontal(i);
        }
        System.out.print(sb);
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}
