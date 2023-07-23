package com.example.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class level2_피로도 {
    private static boolean[] visited = new boolean[8];

    public static void main(String[] args) {
        int[][] t1 = {{80, 20}, {50, 40}, {30, 10}};
        solv(80, t1);

    }

    private static void solv(int k, int[][] dungeons) {
        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        return dfs(k, 0, dungeons);
    }

    private static int dfs(int k, int cnt, int[][] dungeons) {
        int result = cnt;
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            result = Math.max(result, dfs(k - dungeons[i][1], cnt + 1, dungeons));
            visited[i] = false;
        }
        return result;
    }
}
