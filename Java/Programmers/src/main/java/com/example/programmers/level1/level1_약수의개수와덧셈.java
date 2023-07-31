package com.example.programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class level1_약수의개수와덧셈 {
    private Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

    }

    public int solution(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += primeNumberCount(i);
            set.clear();
        }
        return sum;
    }

    private int primeNumberCount(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                set.add(n / i);
                set.add(i);
            }
        }
        return set.size() % 2 == 0 ? n : -n;
    }
}
