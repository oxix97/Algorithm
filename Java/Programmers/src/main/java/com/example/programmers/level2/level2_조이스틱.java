package com.example.programmers.level2;

public class level2_조이스틱 {
    public static void main(String[] args) {
        int a1 = solution("JEROEN");
        int a2 = solution("JAN");
        int a3 = solution("H");
        int a4 = solution("ZZZZ");
        printSolution(a1, a2, a3, a4);
    }

    public static int solution(String name) {
        //1. 이름을 chars 로 변형
        int answer = 0;
        int idx = 0;
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                idx = i + 1;
                while (idx < name.length() && name.charAt(idx) == 'A') ++idx;
                move = Math.min(move, i * 2 + (name.length() - idx));
                move = Math.min(move, i + (name.length() - idx) * 2);
            }
        }
        return answer + move;
    }

    private static void printSolution(int... answer) {
        for (int ans : answer) {
            System.out.println(ans);
        }
    }
}
