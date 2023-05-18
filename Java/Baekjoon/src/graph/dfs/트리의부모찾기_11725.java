package src.graph.dfs;

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
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산 , dfs : nlogn -> 1초이내 가능

        // N(100,000) 노드 개수, list : 그래프, visited : 방문 배열
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        //list 입력값 받기
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        answer = new int[N + 1];
        // 1번 부터 dfs 탐색
        dfs(1);
        for (int i = 2; i <= N; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int n) {
        visited[n] = true;

        for (int next : list[n]) {
            if (!visited[next]) {
                answer[next] = n;
                System.out.println("answer[" + next + "] = " + n);
                dfs(next);
            }
            System.out.println("----------");
        }
    }
}
