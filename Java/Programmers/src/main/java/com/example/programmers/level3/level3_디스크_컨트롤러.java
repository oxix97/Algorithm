package com.example.programmers.level3;

import java.util.*;

public class level3_디스크_컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        int end = 0;
        int idx = 0;
        int cnt = 0;
        int sum = 0;

        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= end) {
                q.add(jobs[idx++]);
            }

            if (q.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] job = q.poll();
                end += job[1];
                sum += end - job[0];
                ++cnt;
            }
        }

        return sum / jobs.length;
    }
}