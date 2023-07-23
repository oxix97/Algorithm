package com.example.programmers.level2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class level2_카펫 {
    public static void main(String[] args) {
        print(10,2);
        print(8,1);
        print(24,24);
        print(18,6);
    }

    public static int[] solution(int brown, int yellow) {
        //1. yellow 타일의 공약수 구하기
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= (int) Math.sqrt(yellow); i++) {
            if (yellow % i == 0)
                list.add(i);
        }

        //2. 해당 공약수는 세로 타일로 가정하여 갈색의 테두리 값 구하기, 반복
        for (int h : list) {
            int w = yellow / h;
            int bw = w + 2;
            int bh = h + 2;
            if ((bw*2) + (bh*2) - 4 == brown)
                return new int[]{bw, bh};
        }

        return null;
    }

    public static void print(int brown, int yellow) {
        int[] solv = solution(brown, yellow);
        System.out.println("[" + solv[0] + ", " + solv[1] + "]");
    }
}