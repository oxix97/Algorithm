package com.example.programmers.level1;

import java.util.*;
public class level1_폰켓몬 {
    public static void main(String[] args) {
        int[] nums1 = {3,1,2,3};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,3,3,2,2,2};
        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
        System.out.println(solution(nums3));
    }

    public static int solution(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) list.add(i);
        HashSet<Integer> set = new HashSet<>(list);

        return Math.min(set.size(), nums.length / 2);
    }
}
