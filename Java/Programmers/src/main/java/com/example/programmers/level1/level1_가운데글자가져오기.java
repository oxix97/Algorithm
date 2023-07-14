package com.example.programmers.level1;

import java.util.*;
public class level1_가운데글자가져오기 {
    public static String solution(String s) {
        String answer = "";
        int index = s.length();
        if(index %2 == 1)
            answer = s.substring(index/2, index/2+1);
        else
            answer = s.substring(index/2-1, index/2+1);
        return answer;
    }
    public static void main(String[] args) {
        String s = "abcde";
        String r = "qwer";

        String ss = solution(s);
        String rr = solution(r);

        System.out.println(ss);
        System.out.println(rr);
    }
}
