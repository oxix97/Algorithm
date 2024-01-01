package com.example.programmers.level3;

public class level3_정수삼각형 {
    public int solution(int[][] triangle) {
        if (triangle.length == 1) return triangle[0][0];

        int height = triangle[triangle.length - 1].length - 2;

        while (height >= 0) {
            for (int i = 0; i < triangle[height].length; i++) {
                triangle[height][i] += Math.max(triangle[height + 1][i], triangle[height + 1][i + 1]);
            }
            height--;
        }
        return triangle[0][0];
    }

    public static void main(String[] args) {
        level3_정수삼각형 prob = new level3_정수삼각형();
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        int a1 = prob.solution(triangle);
        int a2 = prob.solution(new int[][]{{7}, {3, 8}});
        int a3 = prob.solution(new int[][]{{7}});
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}
