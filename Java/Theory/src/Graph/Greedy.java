package Graph;

import java.util.*;

public class Greedy {
    public static void knapsackFunc(int[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, (objectItem1, objectItem2) -> (objectItem2[1] / objectItem2[0]) - (objectItem1[1] / objectItem1[0]));

        for (int[] ints : objectList) {
            if ((capacity - (double) ints[0]) > 0) {
                capacity -= ints[0];
                totalValue += ints[1];
                System.out.println("무게:" + ints[0] + ", 가치:" + ints[1]);
            } else {
                fraction = capacity / (double) ints[0];
                totalValue += (double) ints[1] * fraction;
                System.out.println("무게:" + ints[0] + ", 가치:" + ints[1] + ", 비율:" + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치:" + totalValue);
    }

    public static void main(String[] args) {
        int[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        knapsackFunc(objectList, 30.0);

    }
}
