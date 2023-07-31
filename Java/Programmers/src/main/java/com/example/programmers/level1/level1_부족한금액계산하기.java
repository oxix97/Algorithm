package com.example.programmers.level1;

public class level1_부족한금액계산하기 {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count) {
        long answer = recursion(price, money, count);
        return answer < 0 ? Math.abs(answer) : 0;
    }

    private static long recursion(int price, long money, int count) {
        if (count == 0) {
            return money;
        }
        return recursion(price, money - ((long) price * count), count - 1);
    }
}
