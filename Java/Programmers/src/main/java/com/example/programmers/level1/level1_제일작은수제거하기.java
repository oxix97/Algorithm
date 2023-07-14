package com.example.programmers.level1;

import java.util.*;
public class level1_제일작은수제거하기 {
    /*public static int[] solution(int[] arr){
        if(arr.length==1) return new int[]{-1};

        List<Integer> list = new ArrayList<>();
        for(int i : arr)
            list.add(i);

        int min = Collections.min(list);
        list.remove(list.indexOf(min));

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++)
            answer[i] = list.get(i);

        return answer;

    } */
    public static int[] solution(int[] arr){
        if(arr.length==1) return new int[]{-1};
        OptionalInt min = Arrays.stream(arr).min();
        return Arrays.stream(arr).filter(i -> i != min.getAsInt()).toArray();
    }
    public static void main(String[] args) {
        int[] a1 = {4,3,2,1};
        int[] a2 = {10};

        System.out.println(Arrays.toString(solution(a1)));
        System.out.println(Arrays.toString(solution(a2)));
    }
}
