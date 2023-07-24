package com.example.programmers.level2;

import javax.swing.text.View;
import java.util.LinkedList;
import java.util.Queue;

public class level2_게임_맵_최단거리 {
    static int[][] distance;
    static int[][] MOVE = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상,하,좌,우

    public static void main(String[] args) {

    }

    public static int solution(int[][] maps) {
        distance = new int[maps.length][maps[0].length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        distance[0][0] = 1;

        while (!q.isEmpty()) {
            int[] now = {q.poll(), q.poll()};
            for (int[] next : MOVE) {
                int y = now[0] + next[0];
                int x = now[1] + next[1];
                if (checkMap(y, x, maps)) {
                    q.add(y);
                    q.add(x);
                    distance[y][x] += distance[now[0]][now[1]] + 1;
                }
            }
        }
        int answer = distance[maps.length - 1][maps[0].length - 1];
        return answer == 0 ? -1 : answer;
    }

    private static boolean checkMap(int y, int x, int[][] maps) {
        if (y < 0 || x < 0 || y >= maps.length || x >= maps[0].length) return false;
        if (maps[y][x] == 0) return false;
        return distance[y][x] == 0;
    }
}
