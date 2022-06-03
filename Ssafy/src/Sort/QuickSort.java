package Sort;

import Util.UtilClass;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        UtilClass util = new UtilClass();
        ArrayList<Integer> list = new ArrayList<>();

        util.inputRandomValue(list);

        util.printIntegerList(sort(list));
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int pivot = list.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            int item = list.get(i);
            if (list.get(i) > pivot) {
                right.add(item);
            } else {
                left.add(item);
            }
        }

        ArrayList<Integer> mergeList = new ArrayList<>();
        mergeList.addAll(sort(left));
        mergeList.addAll(Arrays.asList(pivot));
        mergeList.addAll(sort(right));

        return mergeList;
    }
}
