package com.example.programmers.level1;

import java.util.*;
public class level1_3진법뒤집기 {
    public static int solution(int n){
        String num3 = "";
        // 3진법을 구하기 위한 반복문
        while(n>0){
            //3으로 나눈 나머지를 계속 더해준다.
            num3 = (n%3) + num3;
            n /= 3;

        }
        //num3를 뒤집어서 다시 넣음
        num3 = new StringBuffer(num3).reverse().toString();

        // 3진법으로 변환
        int answer = Integer.parseInt(num3,3);

        return answer;
    }
    public static void main(String[] args) {
        int num = 45;
        int ans = solution(num);
        System.out.println(ans);
    }
}
