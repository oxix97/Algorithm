package com.example.programmers.level1;

public class level1_키패드누르기 {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10, right = 12;
        int L_dis, R_dis;

        for (int n : numbers) {
            L_dis = 0;
            R_dis = 0;
            if (n == 1 || n == 4 || n == 7) {
                answer.append("L");
                left = n;
            } else if (n == 3 || n == 6 || n == 9) {
                answer.append("R");
                right = n;
            } else {
                if (n == 0) n += 11;
                L_dis = (Math.abs(n - left)) / 3 + (Math.abs(n - left)) % 3;
                R_dis = (Math.abs(n - right)) / 3 + (Math.abs(n - right)) % 3;
                if (L_dis == R_dis) {
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = n;
                    } else {
                        answer.append("R");
                        right = n;
                    }
                } else if (L_dis > R_dis) {
                    answer.append("R");
                    right = n;
                } else {
                    answer.append("L");
                    left = n;
                }
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        int[] number1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] number2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] number3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] n = {1, 2, 3, 4, 5, 6};
        String answer1 = "LRLLLRLLRRL";
        String answer2 = "LRLLRRLLLRR";
        String answer3 = "LLRLLRLLRL";

        System.out.println(solution(number1,"right").equals(answer1));
        System.out.println(solution(number2,"left").equals(answer2));
        System.out.println(solution(number3,"right").equals(answer3));
    }
}
