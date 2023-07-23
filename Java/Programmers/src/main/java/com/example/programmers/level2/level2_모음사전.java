package com.example.programmers.level2;

import java.util.ArrayList;

public class level2_모음사전 {
    static String[] WORD = {"A", "E", "I", "O", "U"};
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        printSolution("A");
        printSolution("AAAAE");
        printSolution("AAAE");
        printSolution("I");
        printSolution("EIO");
        printSolution("UUUUU");
    }

    private static void printSolution(String word) {
        System.out.println(solution(word));
    }

    public static int solution(String word) {
        recursion("");
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    private static void recursion(String str) {
        list.add(str);

        if (str.length() == 5) return;

        for (String s : WORD) {
            recursion(str + s);
        }
    }
}
