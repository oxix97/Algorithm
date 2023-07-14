package com.example.programmers.level2;

import java.util.*;
public class level2_스킬트리 {

    public static int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for (String skill_tree : skill_trees) {
            int count = 0;
            for (int j = 0; j < skill_tree.length(); j++) {
                String s = skill_tree.substring(j, j + 1);
                if (skill.contains(s)) {
                    if (skill.indexOf(s) == count)
                        count++;
                    else {
                        count = -1;
                        break;
                    }
                }
            }
            if (count == -1)
                answer--;
        }
        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTree = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill,skillTree));
    }
}
