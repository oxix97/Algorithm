package com.example.programmers.level3;

public class level3_네트워크 {
    static boolean[] visited;

    public static void main(String[] args) {

    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i, computers);
            ++answer;
        }
        return answer;
    }

    private static void dfs(int n, int[][] computers) {
        visited[n] = true;
        for (int i = 0; i < computers[n].length; i++) {
            if (visited[i] || computers[n][i] == 0) continue;
            dfs(i, computers);
        }
    }
}
