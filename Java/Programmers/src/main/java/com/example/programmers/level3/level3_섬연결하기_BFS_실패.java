package com.example.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class level3_섬연결하기_BFS_실패 {
    public static void main(String[] args) {
        int[][] a1 = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int s1 = solution(4, a1);
        printSolv(s1);
    }

    public static int solution(int n, int[][] costs) {
        int answer = Integer.MAX_VALUE;
        ArrayList<Cost>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] cost : costs) {
            if (cost.length == 2) continue;
            edges[cost[0]].add(new Cost(cost[1], cost[2]));
            edges[cost[1]].add(new Cost(cost[0], cost[2]));
        }

        boolean[] visited = new boolean[n];

        for (ArrayList<Cost> edge : edges) {
            for (Cost c : edge) {
                System.out.print("[" + c.idx + ", " + c.v + "]");
            }
            System.out.println();
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            q.add(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                if (tmp > answer) break;
                int now = q.poll();
                for (Cost cost : edges[now]) {
                    if (visited[cost.idx]) continue;
                    visited[cost.idx] = true;
                    tmp += cost.v;
                    q.add(cost.idx);
                }
            }
            answer = Math.min(answer, tmp);
            Arrays.fill(visited, false);
            q.clear();
        }
        return answer;
    }

    static class Cost {
        int idx, v;

        public Cost(int idx, int v) {
            this.idx = idx;
            this.v = v;
        }
    }

    private static void printSolv(int... answer) {
        for (int ans : answer) System.out.println(ans);
    }
}
