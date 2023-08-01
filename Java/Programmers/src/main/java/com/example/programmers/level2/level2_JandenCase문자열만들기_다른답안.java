package com.example.programmers.level2;

public class level2_JandenCase문자열만들기_다른답안 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed     me   "));
        System.out.println(solution(" "));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean firstLetter = true;
        for (String str : s.toLowerCase().split("")) {
            sb.append(firstLetter ? str.toUpperCase() : str);
            firstLetter = str.equals(" ");
        }
        return sb.toString();
    }
}
