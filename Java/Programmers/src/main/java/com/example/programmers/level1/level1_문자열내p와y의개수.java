package com.example.programmers.level1;

import java.util.*;
public class level1_문자열내p와y의개수 {
    public static boolean solution (String s) {
        int countP = 0;
        int countY = 0;
        String str = s.toLowerCase();

        for(int i=0; i<str.length();i++) {
            if(s.charAt(i) == 'p') countP++;
            if(s.charAt(i)== 'y') countY++;
        }
        if(countP==countY)
            return true;
        return false;
    }
    public static void main(String[] args) {
        String s1 = "pPoooyY";
        String s2 = "Pyy";

        boolean ans1 = solution(s1);
        boolean ans2 = solution(s2);

        System.out.println("s1 is true? : "+ans1);
        System.out.println("s2 is true? : "+ans2);
    }
}
