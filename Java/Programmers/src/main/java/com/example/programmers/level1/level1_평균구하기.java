package com.example.programmers.level1;

import java.util.*;
import java.util.stream.*;
public class level1_평균구하기 {
    public static double solution(int[] arr) {
        return (double)IntStream.of(arr).sum()/arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(solution(arr));
    }
}