package com.example.programmers.level1;

import java.util.*;
public class level1_비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] temp1 = new String[n];
        String[] temp2 = new String[n];
        int max = 0;
        for(int i=0; i<n;i++) {
            temp1[i] = Integer.toBinaryString(arr1[i]);
            temp2[i] = Integer.toBinaryString(arr2[i]);
            if(max<temp1[i].length() || max<temp2[i].length())
                max = Math.max(temp1[i].length(), temp2[i].length());
        }
        for(int i=0; i<n;i++) {
            String t1 = "";
            String t2 = "";
            for(int j=temp1[i].length();j<max;j++)
                t1 +="0";
            for(int j=temp2[i].length();j<max;j++)
                t2 +="0";
            temp1[i] = t1+temp1[i];
            temp2[i] = t2+temp2[i];
        }
        for(int i=0; i<n; i++) {
            String temp = "";
            for(int j=0; j<max;j++) {
                if(temp1[i].substring(j,j+1).equals(temp2[i].substring(j, j+1))) {
                    if(temp1[i].charAt(j) == '0')
                        temp += " ";
                    else
                        temp += "#";
                }
                else
                    temp += "#";
            }
            answer[i] = temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(Arrays.asList(solution(n,arr1,arr2)));
    }
}
