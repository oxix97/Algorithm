package com.example.programmers.level2;

public class level2_큰수만들기_그리디X {
    public static void main(String[] args) {
        String s1 = solution("1924", 2);
        String s2 = solution("1231234", 3);
        String s3 = solution("4177252841", 4);
        String s4 = solution("100", 1);
        printSolv(s1, s2, s3, s4);
    }

    //number 2 자리 이상  10^6 자리 이하, k 1 이상 number.length 미만
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] nums = number.toCharArray();
        if (nums.length == 2) {
            sb.append(nums[0] > nums[1] ? nums[0] : nums[1]);
            return sb.toString();
        }
        boolean[] check = new boolean[number.length()];
        for (int i = 1; i < nums.length && k != 0; i++) {
            int now = nums[i] - '0';
            for (int j = i - 1; j >= 0 && k != 0; j--) {
                int pre = nums[j] - '0';
                if (now <= pre) break;
                if (!check[j]) {
                    check[j] = true;
                    k--;
                }
            }
        }

        if (k != 0) {
            return sb.append(number, 0, nums.length - k).toString();
        }

        for (int i = 0; i < nums.length; i++) {
            if (check[i]) continue;
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static void printSolv(String... answer) {
        for (String ans : answer) {
            System.out.println(ans);
        }
    }
}
