package src.graph.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int V, E;
    static PriorityQueue<Edge> queue;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        // V(10,000) : 노드 개수, E(100,000) 간선 개수
        // A,B정점 , C : A->B의 가중치 (음수일 수도 있다.) abs(1,000,000)
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 유니온 파인드 배열 초기화
        arr = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = i;
        }

        // 에지 리스트 초기화 및 입력
        queue = new PriorityQueue<>();
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queue.add(new Edge(a, b, c));
        }

        int useEdge = 0;
        int result = 0;

        while (useEdge < V - 1) {
            Edge now = queue.poll();
            if (find(now.node1) != find(now.node2)) {
                union(now.node1, now.node2);
                result = result + now.value;
                useEdge++;
            }
        }
        System.out.println(result);

        br.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }

    private static int find(int a) {
        if (a == arr[a]) return a;
        return arr[a] = find(arr[a]);
    }

    static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int value;

        public Edge(int node1, int node2, int value) {
            this.node1 = node1;
            this.node2 = node2;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.value > e.value) return 1;
            else return -1;
        }
    }

}
