package com.example.programmers.level1;

public class level1_짝수와홀수 {
    public static String solution(int num) {
        return num%2 != 0 ? "Odd" : "Even";
    }

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 4;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }
}
