package com.example.programmers.level2;

import java.util.Arrays;

public class level2_H_Index {
    public static void main(String[] args) {
        int[] tc1 = {3, 0, 6, 1, 5};
        int[] tc2 = {0, 0, 6, 1, 5};
        int[] tc3 = {0, 0, 6, 1, 5, 7, 8, 11, 2};
        int[] tc4 = {0, 5, 6, 7, 8};

        print(tc1);
        print(tc2);
        print(tc3);
        print(tc4);
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i)
                return citations.length - i;
        }
        return 0;
    }

    private static void print(int[] tc) {
        System.out.println(solution(tc));
    }
}

/**
 * 0,1,3,5,6
 * <p>
 * 1. 받은 배열 정렬
 * 2. index = 0 부터 검사하여 값 + 1 이 남은 길이와 비교하여 H-index 값 지정
 * 3. 종료 조건 : H-index 값이 되지 못하는 순간 종료
 */