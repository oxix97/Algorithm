package com.example.programmers.level1;

import java.util.*;
public class level1_두정수사이의합 {
    public static long solution(int a, int b) {
        long answer = 0;
        if(a>b){
            int temp = b;
            b = a;
            a = temp;
        }else if(a == b)
            return a;

        for(int i=0;i<=b-a;i++){
            answer += (a+i);
        }

        return answer;
    }

    public static void main(String[] args) {
        long answer = solution(4,5);
        System.out.println("answer : "+answer);
    }
}
