package com.example.programmers.level3;

import java.util.Arrays;

public class level3_단속카메라 {
    public static void main(String[] args) {
        int[][] a1 = {{-20, -15}, {-14, -5}, {-18, -13}, {-3, 1}, {1, 4}};
        int[][] a2 = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int s1 = solution(a1);
        int s2 = solution(a2);
        printSolv(s1, s2);
    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int answer = 0;

        for (int i = 0; i < routes.length; i++) {
            int to = routes[i][1];
            while (i + 1 < routes.length && to >= routes[i + 1][0]) ++i;
            ++answer;
        }
        for (int[] route : routes) {
            System.out.println("["+route[0]+","+route[1]+"]");
        }
        return answer;
    }

    private static void printSolv(int... answer) {
        for (int ans : answer) System.out.println(ans);
    }
}
