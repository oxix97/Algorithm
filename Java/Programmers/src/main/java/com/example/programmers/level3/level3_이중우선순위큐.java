package com.example.programmers.level3;

import java.util.*;

public class level3_이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        solution(operations);
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (String operator : operations) {
            StringTokenizer st = new StringTokenizer(operator);
            String judge = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (judge.equals("I")) {
                max.offer(value);
                min.offer(value);
                continue;
            }

            if (min.isEmpty()) continue;

            int n;
            if (value == -1) {
                n = min.poll();
                max.remove(n);
            } else {
                n = max.poll();
                min.remove(n);
            }
        }

        int[] answer = new int[2];
        if (!min.isEmpty()) {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }

        return answer;
    }
}
