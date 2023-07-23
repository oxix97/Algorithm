package com.example.programmers.level2;

import java.util.*;
import java.util.stream.Stream;

public class level2_소수찾기 {
    private static final int MAX_VALUE = 9_999_999;
    private static Set<Integer> set = new HashSet<>();
    private static boolean[] visited = new boolean[7];

    public static void main(String[] args) {
        System.out.println(solution("17"));
        set.clear();
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
//        1. 주어진 문자열로 만들 수 있는 숫자의 경우 구하기
        dfs("", 0, numbers);

//        2. 전체 경우 소수 구하기 -> numbers는 7이하 문자열 최대 9,999,999
        int[] prime = new int[MAX_VALUE + 1];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for (int i = 2; i * i <= MAX_VALUE; i++) {
            if (prime[i] == 0) continue;

            for (int j = 2; i * j <= MAX_VALUE; j++) {
                prime[i * j] = 0;
            }
        }
//        3. 각 숫자별로 소수인지 판별
        return (int) set.stream().filter(it -> prime[it] == 1).count();
    }

    private static void dfs(String str, int idx, String numbers) {
        if (!str.equals(""))
            set.add(Integer.parseInt(str));

        if (idx == numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(str + numbers.charAt(i), idx + 1, numbers);
            visited[i] = false;
        }
    }
}


/**
 * 1. 주어진 문자열로 만들 수 있는 숫자의 경우 구하기
 * 2. 각 숫자별로 소수인지 판별하기
 * 3. 소수이면 ++answer
 */