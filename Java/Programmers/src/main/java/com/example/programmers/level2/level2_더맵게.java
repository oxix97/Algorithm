package com.example.programmers.level2;

import java.util.PriorityQueue;

public class level2_더맵게 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 9, 3, 10, 12}, 7));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1}, 21));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int v : scoville) {
            q.add(v);
        }

        int answer = 0;
        while (q.size() > 1) {
            int x = q.poll();
            int y = q.poll();
            if (x >= K && y >= K) return answer;

            q.add(x + (y * 2));
            ++answer;
        }

        return q.poll() >= K ? answer : -1;
    }
}
