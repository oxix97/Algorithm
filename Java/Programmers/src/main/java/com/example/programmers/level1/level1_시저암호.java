package com.example.programmers.level1;

import java.util.*;
import java.io.*;
import java.math.*;
public class level1_시저암호 {
    public static String solution(String s, int n){
        char[] temp = s.toCharArray();
        for(int i=0;i<temp.length;i++){
            if(temp[i]<=90 && temp[i]+n>90)
                temp[i] = (char) ((temp[i]+n) % 91 + 'A');
            else if(temp[i]>=97 && temp[i]+n>122)
                temp[i] = (char) ((temp[i]+n) % 123 + 'a');
            else if(temp[i] != ' ')
                temp[i] += n;
        }
        return new String(temp);
    }

    public static void main(String[] args) {
        System.out.println(solution("AB",1));
    }
}
