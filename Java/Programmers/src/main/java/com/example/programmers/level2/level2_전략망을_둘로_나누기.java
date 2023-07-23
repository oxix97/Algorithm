package com.example.programmers.level2;

import java.util.*;

public class level2_전략망을_둘로_나누기 {
    static boolean[] visited;
    static List<Integer>[] nodes;

    public static void main(String[] args) {
        int[][] t1 = {
                {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}
        };
        int[][] t2 = {
                {1, 2}, {2, 3}, {3, 4}
        };
        int[][] t3 = {
                {1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}
        };
        printSolution(9, t1);
        printSolution(4, t2);
        printSolution(7, t3);
    }

    public static void printSolution(int n, int[][] wires) {
        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires) {
        //1. list에 삽입하여 연결
        nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            nodes[i] = new ArrayList<>();

        for (int[] wire : wires) {
            nodes[wire[0]].add(wire[1]);
            nodes[wire[1]].add(wire[0]);
        }

        //2. 연결선 제거 후 BFS로 탐색하여 연결 개수 도출
        visited = new boolean[n + 1];

        int answer = n;
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            nodes[a].removeIf(it -> it == b);
            nodes[b].removeIf(it -> it == a);
            int cnt = bfs(a);
            int tmp = n - cnt;
            answer = Math.min(answer, Math.abs(tmp - cnt));

            nodes[a].add(b);
            nodes[b].add(a);
            Arrays.fill(visited, false);
        }

        return answer;
    }

    private static int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int nx = q.poll();
            visited[nx] = true;
            for (int v : nodes[nx]) {
                if (visited[v]) continue;
                q.add(v);
                ++cnt;
            }
        }
        return cnt;
    }
}
