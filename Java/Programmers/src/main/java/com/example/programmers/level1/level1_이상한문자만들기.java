package com.example.programmers.level1;

import java.util.*;
public class level1_이상한문자만들기 {
    public static String solution(String s){
        String[] str = s.split("");
        String answer = "";
        int count = 0;

        for(String word : str){
            count = word.equals(" ") ? 0 : ++count;
            answer += (count % 2 != 0) ? word.toUpperCase() : word.toLowerCase();
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = "Hello World Try";
        System.out.println(solution(str));
    }
}
