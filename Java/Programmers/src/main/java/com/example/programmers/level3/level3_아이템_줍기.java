package com.example.programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class level3_아이템_줍기 {
    static int[][] map = new int[101][101];
    static int[][] distance = new int[101][101];
    static final int[][] MOVE = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int[][] t1 = {{1, 1, 7, 4}, {3, 2, 5, 5}, {2, 6, 8, 8}, {4, 3, 6, 9}};
        int solv = solution(t1, 1, 3, 7, 8);

        System.out.println(solv);
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[] start = {characterY * 2, characterX * 2};
        int[] end = {itemY * 2, itemX * 2};

        drawMap(rectangle);
        Queue<Integer> q = new LinkedList<>();
        q.add(start[0]);
        q.add(start[1]);
        distance[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();

            for (int[] move : MOVE) {
                int nextY = nowY + move[0];
                int nextX = nowX + move[1];
                if (checkMap(nextY, nextX)) {
                    q.add(nextY);
                    q.add(nextX);
                    distance[nextY][nextX] = (distance[nowY][nowX] + 1);
                }
            }
        }

        return distance[end[0]][end[1]] / 2;
    }

    private static boolean checkMap(int y, int x) {
        if (y < 1 || x < 1 || y > 100 || x > 100) return false;
        if (map[y][x] != 1) return false;
        return distance[y][x] == 0;
    }

    private static void drawMap(int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            int leftX = rectangle[i][0] * 2;
            int leftY = rectangle[i][1] * 2;
            int rightX = rectangle[i][2] * 2;
            int rightY = rectangle[i][3] * 2;

            for (int x = leftX; x <= rightX; x++) {
                if (map[leftY][x] == 0) map[leftY][x] = 1;
                if (map[rightY][x] == 0) map[rightY][x] = 1;
            }

            for (int y = leftY; y <= rightY; y++) {
                if (map[y][leftX] == 0) map[y][leftX] = 1;
                if (map[y][rightX] == 0) map[y][rightX] = 1;
            }

            for (int y = leftY + 1; y < rightY; y++) {
                for (int x = leftX + 1; x < rightX; x++) {
                    map[y][x] = 2;
                }
            }
        }
    }
    /**
     * 1. rectangle에 들어있는거 map에다가 그리기 -> 사각형의 선 : 1, 내부 : 2, 빈 공간 : 0
     * 1-1) 빈 공간일 때만 선을 그린다 map[i][j]=0or1 경우에만 1 삽입
     * 1-2) 선과 사각형의 내부 공간이 겹치는 경우 내부 공간으로 인지 map[i][j]=2 경우에 선은 그리지 않는다.
     *
     * 2. 최단거리 문제이므로 BFS 활용, map[i][j]=1 인 경우만 탐색, distance 배열을 활용 하여 값을 채워 나간다.
     *
     */
}
