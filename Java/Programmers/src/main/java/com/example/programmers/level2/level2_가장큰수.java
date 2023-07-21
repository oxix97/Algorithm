package com.example.programmers.level2;

import java.util.*;

public class level2_가장큰수 {
    public static void main(String[] args) {
        String t1 = solution(new int[]{6, 10, 2});
        System.out.println(t1);
        String t2 = solution(new int[]{3, 30, 34, 5, 9});
        System.out.println(t2);
        String t3 = solution(new int[]{0, 0, 0});
        System.out.println(t3);
        String t4 = solution(new int[]{0, 1, 0, 10});
        System.out.println(t4);
    }

    public static String solution(int[] numbers) {
        List<Number> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(new Number(Integer.toString(number)));
        }

        Collections.sort(list);

        if (list.get(0).num.equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (Number item : list) {
            sb.append(item.num);
        }

        return sb.toString();
    }

    static class Number implements Comparable<Number> {
        String num;

        public Number(String num) {
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            int t1 = Integer.parseInt(this.num + o.num);
            int t2 = Integer.parseInt(o.num + this.num);

            return t2 - t1;
        }
    }
}
