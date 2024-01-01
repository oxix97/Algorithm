package src.graph.bfs;

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
    static int answer = Integer.MIN_VALUE;
    static int cnt;
    static int[] result;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

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
        result = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            cnt = 0;
            bfs(i);
            result[i] = cnt;
            answer = Math.max(answer, cnt);
        }
    }

    private static void output() {
        for (int i = 1; i <= N; i++) {
            if (result[i] == answer)
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int nx : list.get(x)) {
                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(nx);
                    ++cnt;
                }
            }
        }
    }
}
