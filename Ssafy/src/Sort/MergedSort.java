package Sort;

import Util.UtilClass;

import java.util.ArrayList;

public class MergedSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        UtilClass util = new UtilClass();
        util.inputRandomValue(list);

        util.printIntegerList(splitFunc(list));
    }

    private static ArrayList<Integer> splitFunc(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int medium = list.size() / 2;

        ArrayList<Integer> left = splitFunc(new ArrayList<>(list.subList(0, medium)));
        ArrayList<Integer> right = splitFunc(new ArrayList<>(list.subList(medium + 1, list.size())));

        return mergeFunc(left, right);
    }

    private static ArrayList<Integer> mergeFunc(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        int lPoint = 0;
        int rPoint = 0;

        while (left.size() > lPoint && right.size() > rPoint) {
            if (left.get(lPoint) > right.get(rPoint)) {
                mergeList.add(right.get(rPoint));
                ++rPoint;
            } else {
                mergeList.add(left.get(lPoint));
                ++lPoint;
            }
        }

        //left 리스트에 남은 것 모두 mergeList에 추가한다.
        while (left.size() > lPoint) {
            mergeList.add(left.get(lPoint));
            lPoint++;
        }

        //right 리스트에 남은 것 모두 mergeList에 추가한다.
        while (right.size() > rPoint) {
            mergeList.add(right.get(rPoint));
            rPoint++;
        }

        return mergeList;

    }
}
