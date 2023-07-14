package com.example.programmers.level1;

import java.util.*;
public class level1_정수제곱근판별 {
    public static long solution(long n){
        return (long)Math.sqrt(n) != (float)Math.sqrt(n) ? -1 : (long)Math.pow(Math.sqrt(n)+1, 2);
    }
    public static void main(String[] args) {
        long n1 = 121;
        long n2 = 3;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }
}
