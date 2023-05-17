package src.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기_1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Edge>[] list;
    static int[] distances;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인

        //1. 각 입력값들의 파라미터 정리
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, cost));
        }

        //2. 최소 거리 배열 생성 및 초기화 / visited 배열 초기화
        distances = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        //3.from, to 입력 받기
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        //4. bfs를 사용하여 최단 경로 구하기 distances[from] = 0 ->
        distances[from] = 0;
        bfs(new Edge(from, 0));

        //5. 출력
        System.out.println(distances[to]);

        br.close();
    }

    private static void bfs(Edge e) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(e);

        while (!q.isEmpty()) {
            Edge now = q.poll();
            if (visited[now.v]) continue;
            visited[now.v] = true;

            for (Edge next : list[now.v]) {
                if (distances[next.v] > distances[now.v] + next.c) {
                    distances[next.v] = distances[now.v] + next.c;
                    q.add(new Edge(next.v, distances[next.v]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int c;

        public Edge(int vertex, int cost) {
            this.v = vertex;
            this.c = cost;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.c > e.c) return 1;
            return -1;
        }
    }
}
