package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class Bubble {
    public static void main(String[] args) {
        int[] pre = {9,2,3,1,4,5,66,7,9,8};
        for (int i = 0; i < pre.length-1; i++) {
            for (int j = 0; j < pre.length-1; j++) {
                if (pre[j] > pre[j + 1]) {
                    int temp = pre[j+1];
                    pre[j+1] = pre[j];
                    pre[j] = temp;
                }
            }

        }
        for (int i : pre) {
            System.out.print(i+" ");
        }
        System.out.println();
        bubbleCollections();
    }

    public static void bubbleCollections() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int)(Math.random()*100)+1);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list,j,j+1);
                    swap = true;
                }
            }
            if (!swap)
                break;
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
