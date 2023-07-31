package com.example.programmers.level1;

import java.util.Arrays;

public class level1_없는숫자더하기 {
    public static int solution(int[] numbers) {
        int[] num = new int[10];
        for (int n : numbers) {
            ++num[n];
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (num[i] == 0)
                sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] t1 = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(solution(t1));
    }
}
