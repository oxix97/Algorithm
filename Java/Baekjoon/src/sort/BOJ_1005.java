package src.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int TC, N, K, W;
    static int[] T_done;
    static int[] inDegree;
    static int[] T;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            solution();
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static void solution() throws IOException {
        inputs();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                T_done[i] = T[i];
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) q.add(next);
                T_done[next] = Math.max(T_done[next], T_done[now] + T[next]);
            }
        }
        sb.append(T_done[W]).append('\n');
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        T = new int[N + 1];
        T_done = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        inDegree = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            inDegree[y]++;
        }
        W = Integer.parseInt(br.readLine());
    }
}
