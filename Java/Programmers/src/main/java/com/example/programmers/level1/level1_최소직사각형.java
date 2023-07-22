package com.example.programmers.level1;

public class level1_최소직사각형 {
    public static void main(String[] args) {
        int[][] tc1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] tc2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7},{5,15}};
        int[][] tc3 = {{14,4}, {19, 6}, {6, 16}, {18, 7},{7,11}};
        System.out.println(solution(tc1));
        System.out.println(solution(tc2));
        System.out.println(solution(tc3));
    }

    public static int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxWidth * maxHeight;
    }
}
