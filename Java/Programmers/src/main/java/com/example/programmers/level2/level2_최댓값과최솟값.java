package com.example.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class level2_최댓값과최솟값 {
    public static void main(String[] args) {

    }

    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        for (String n : s.split(" ")) {
            list.add(Integer.parseInt(n));
        }
        Collections.sort(list);

        return list.get(0).toString() + " " + list.get(list.size() - 1).toString();
    }
}
