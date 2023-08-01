package com.example.programmers.level2;

public class level2_JadenCase문자열만들기 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed     me   "));
        System.out.println(solution(" "));
    }

    public static String solution(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            String now = strings[i];

            if (now.length() == 0) {
                sb.append(" ");
                continue;
            }

            sb.append(now.substring(0, 1).toUpperCase());
            sb.append(now.substring(1).toLowerCase());
            if (i != strings.length - 1) sb.append(" ");
        }
        if (s.charAt(s.length() - 1) == ' ') sb.append(" ");
        return sb.toString();
    }
}
