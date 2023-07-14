package com.example.programmers.level2;

import java.util.Stack;

public class level2_올바른괄호 {
    static class Solution {
        boolean solution(String s) {
            Stack<Integer> stack = new Stack<>();
            char[] inputs = s.toCharArray();

            try {
                for (char c : inputs) {
                    if (c == '(')
                        stack.push(0);
                    else
                        stack.pop();
                }
            } catch (Exception e) {
                return false;
            }

            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] test = {"()()", "(())()", ")()(", "(()("};

        for (String s : test) {
            System.out.println(sol.solution(s));
        }
    }
}
