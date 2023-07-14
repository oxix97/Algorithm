package com.example.programmers.level1;

import java.util.*;
public class level1_x만큼n간격이있는숫자 {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0; i<n; i++)
            answer[i] = (long)x*(i+1);
        return answer;
    }
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        long[] answer = solution(x,n);
        for(long i : answer)
            System.out.println(i);
    }
}
