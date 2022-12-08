import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기_11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        init();
        bfs(1);
        printResult();
    }

    private static void printResult() {
        for (int i = 2; i <= N; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void init() {
        visited[1] = 1;
        for (int i : list[1]) {
            visited[i] = 1;
        }
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>(list[n]);

        for (int i : q) {
            if (visited[i] != 0) continue;
            visited[i] = n;
        }

        while (!q.isEmpty()) {
            int num = q.poll();

            for (int i = 0; i < list[num].size(); i++) {
                int item = list[num].get(i);
                if (visited[item] == 0) {
                    visited[item] = num;
                    q.add(item);
                }
            }
        }

    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new int[N + 1];
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
        Arrays.fill(visited, 0);
    }
}
