package com.example.programmers.level2;

import java.util.*;

public class level2_구명보트 {
    public static void main(String[] args) {
        int a1 = solution(new int[]{70, 50, 80, 50}, 100);
        int a2 = solution(new int[]{70, 80, 50}, 100);
        printSolv(a1,a2);
    }

    //보트는 한번에 2명만 탈 수 있다.
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int piv = 0;
        Arrays.sort(people);
        for (int idx = people.length - 1; idx >= piv; idx--) {
            if (people[idx] + people[piv] <= limit) ++piv; //2명 탑승
            ++answer;
        }
        return answer;
    }

    private static void printSolv(int... answer) {
        for (int ans : answer) System.out.println(ans);
    }
}
