package com.example.programmers.level1;

import java.util.*;
public class level1_약수의합 {
    public static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n;i++)
            if(n%i == 0) answer+=i;
        return answer;
    }
    public static void main(String[] args) {
        int n = 12;
        System.out.println(solution(n));
    }
}
