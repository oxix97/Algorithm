package com.example.programmers.level3;

import java.util.*;

public class level3_여행경로 {
    static boolean[] visited;
    static ArrayList<String> cities;

    public static void main(String[] args) {
        String[][] t1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] t2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        printSolution(t1);
        printSolution(t2);
    }

    private static void printSolution(String[][] tickets) {
        String[] answer = solution(tickets);
        System.out.println(Arrays.stream(answer).toList());
    }

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        cities = new ArrayList<>();
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(cities);
        return cities.get(0).split(" ");
    }

    private static void dfs(int cnt, String from, String answer, String[][] tickets) {
        if (cnt == tickets.length) {
            cities.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(from)) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}

