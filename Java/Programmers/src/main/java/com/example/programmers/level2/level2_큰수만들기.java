package com.example.programmers.level2;

public class level2_큰수만들기 {
    public static void main(String[] args) {
        String s1 = solution("1924", 2);
        String s2 = solution("1231234", 3);
        String s3 = solution("4177252841", 4);
        String s4 = solution("100", 2);
        String s5 = solution("10", 1);
        printSolv(s1, s2, s3, s4, s5);
    }

    //number 2 자리 이상  10^6 자리 이하, k 1 이상 number.length 미만
    public static String solution(String number, int k) {
        char[] nums = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < number.length() && sb.length() != number.length() - k) {
            int len = k + sb.length() + 1;
            int max = 0;
            for (int i = idx; i < len; i++) {
                if (max < nums[i] - '0') {
                    max = nums[i] - '0';
                    idx = i + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    public static void printSolv(String... answer) {
        for (String ans : answer) {
            System.out.println(ans);
        }
    }
}
