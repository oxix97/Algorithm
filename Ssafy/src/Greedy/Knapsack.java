package Greedy;

import Util.UtilClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {
    public static void main(String[] args) {
        UtilClass util = new UtilClass();
        int[][] list = util.inputKnapsackList();
        double totalValue = 0.0;
        double fraction = 0.0;
        double capacity = 30;
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] / o2[0] - o1[1] / o1[0];
            }
        });

        for (int[] i : list) {
            //정렬된 리스트의 무게를 빼고도 무게가 남나? -> 분할 필요 x
            if (capacity - (double) i[0] > 0) {
                capacity -= i[0];
                totalValue += i[1];
            } else { // 무게가 남지 않아서 물품을 분할해야 하는 경우
                fraction = capacity / i[0];
                totalValue += fraction * i[1];
                break;
            }
        }
        System.out.println("totalValue : " + totalValue);
    }
}
