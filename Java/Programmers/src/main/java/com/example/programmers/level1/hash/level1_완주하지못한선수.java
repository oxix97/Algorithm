package com.example.programmers.level1.hash;

import java.util.HashMap;

public class level1_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        return "^0^";
    }
}
