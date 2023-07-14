package com.example.programmers.level1;

import java.util.*;
public class level1_prob_02 {
    static int solution(int[] a, int[] b){
        int answer = 0;
        int[] sum = new int[a.length];

        for(int i=0;i<sum.length;i++){
            sum[i] = a[i] * b[i];
        }

        for(int i=0;i<sum.length;i++){
            answer += sum[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        int answer = solution(a,b);

        System.out.println(answer);
    }
}
