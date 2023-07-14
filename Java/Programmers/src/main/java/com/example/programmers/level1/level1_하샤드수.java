package com.example.programmers.level1;

import java.util.*;
public class level1_하샤드수 {
    public static boolean solution(int x) {
        String temp = Integer.toString(x);
        int num = 0;
        for(int i=0; i<temp.length();i++)
            num += Integer.parseInt(temp.substring(i, i+1));

        return x % num == 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(11));
        System.out.println(solution(12));
    }
}
