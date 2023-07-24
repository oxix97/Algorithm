package com.example.programmers.level2;

public class level2_타겟_넘버 {
    static int answer = 0;

    public static void main(String[] args) {
        int[] t1 = {1, 1, 1, 1, 1};
        printSolution(t1, 3);
    }

    public static int solution(int[] numbers, int target) {
        recursion(numbers, target, 0, 0);
        return answer;
    }

    private static void recursion(int[] numbers, int target, int now, int idx) {
        if (idx == numbers.length) {
            if (now == target)
                ++answer;
            return;
        }

        recursion(numbers, target, now + numbers[idx], idx + 1);
        recursion(numbers, target, now - numbers[idx], idx + 1);
    }

    private static void printSolution(int[] numbers, int target) {
        System.out.println(solution(numbers, target));
    }
}
