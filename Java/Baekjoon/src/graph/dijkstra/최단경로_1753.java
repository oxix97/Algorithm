package src.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int V, E, K;
    static ArrayList<Edge>[] list;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //V(1~20,000) : 정점 개수, E(1~300,000) : 간선 개수
        // K(1~V) : 시작 정점
        // E개 반복 , u -> v , w : 가중치

        //1. 입력값 받기
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        //2. 최단 거리 배열 생성 및 초기화
        arr = new int[V + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[K] = 0;

        //3. bfs로 탐색 , 시작 노드 K번째 부터 탐색
        bfs(new Edge(K, 0));

        //4. 최단 거리 배열 출력
        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                sb.append(arr[i]).append('\n');
            } else {
                sb.append("INF").append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void bfs(Edge e) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(e);

        while (!q.isEmpty()) {
            Edge now = q.poll();
            if (visited[now.idx]) continue;
            visited[now.idx] = true;
            for (Edge next : list[now.idx]) {
                if (arr[next.idx] > next.value + arr[now.idx]) {
                    arr[next.idx] = next.value + arr[now.idx];
                    q.add(new Edge(next.idx, arr[next.idx]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int idx;
    int value;

    public Edge(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        if (this.value > e.value) return 1;
        return -1;
    }
}