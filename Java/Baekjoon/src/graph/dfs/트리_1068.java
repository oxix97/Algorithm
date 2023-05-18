package src.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리_1068 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer = 0;
    static int target;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        // N(50), N-1 번 반복, 0 ~ N-1번 까지 노드있음

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        //입력값 입력 : root, list, target
        int root = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) {
                root = i;
                continue;
            }

            list[n].add(i);
            list[i].add(n);
        }
        // 트리에서 노드를 자른다 -> 이미 방문 처리, root값 부터 dfs 탐색
        target = Integer.parseInt(br.readLine());
        if (root == target) {
            System.out.println(0);
        }

        dfs(root);
        System.out.println(answer);
        br.close();
    }

    private static void dfs(int now) {
        //절단된 노드 방문시 종료
        int cnt = 0;
        visited[now] = true;
        for (int next : list[now]) {
            if (!visited[next] && next != target) {
                ++cnt;
                dfs(next);
            }
        }

        // 리프 노드 이므로 ++answer;
        if (cnt == 0) ++answer;
    }
}
