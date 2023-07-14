package com.example.programmers.level1;

import java.util.*;
public class level1_실패율 {
    public static int[] solution(int N, int[] stages) {
        ArrayList<Double> list = new ArrayList<>();
        int[] answer = new int[N];
        double[] rate = new double[N];
        double size = stages.length;
        for(int i=0;i<N;i++) {
            double count =0;
            for (int stage : stages) {
                if (stage == i + 1)
                    count++;
            }
            if(count==0 && size==0)
                rate[i]=0;
            else
                rate[i] = count/size;
            list.add(rate[i]);
            size -= count;
        }
        for(int i=0; i<N;i++) {
            double max = list.get(0);
            for (Double aDouble : list) {
                if (max < aDouble)
                    max = aDouble;
            }
            answer[i] = list.indexOf(max)+1;
            list.add(list.indexOf(max)+1,-1.0);
            list.remove(max);
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
