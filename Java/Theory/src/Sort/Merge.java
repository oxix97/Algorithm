package Sort;

import java.util.ArrayList;
import java.util.*;

public class Merge {
    public ArrayList<Integer> split(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) return dataList;
        int mid = dataList.size() / 2;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        leftList = this.split(new ArrayList<Integer>(dataList.subList(0,mid)));
        rightList = this.split(new ArrayList<Integer>(dataList.subList(mid, dataList.size())));

        return this.merge(leftList, rightList);
    }

    public ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
         int left = 0, right = 0;
        ArrayList<Integer> mergeList = new ArrayList<>();

        while (leftList.size() > left && rightList.size() > right) {
            if (leftList.get(left) > rightList.get(right)) {
                mergeList.add(rightList.get(right));
                ++right;
            } else {
                mergeList.add(leftList.get(left));
                ++left;
            }
        }
        while (rightList.size() > right) {
            mergeList.add(rightList.get(right));
            ++right;
        }
        while (leftList.size() > left) {
            mergeList.add(leftList.get(left));
            ++left;
        }
        return mergeList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Merge merge = new Merge();
        arr.add(5);
        arr.add(15);
        arr.add(51);
        arr.add(533);
        arr.add(75);
        arr.add(53);
        arr = merge.split(arr);
        System.out.println(arr);
    }
}
//public class Merge {
//    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
//        ArrayList<Integer> mergedList = new ArrayList<Integer>();
//        int leftPoint = 0;
//        int rightPoint = 0;
//
//        // CASE1: left/right 둘 다 있을 때
//        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
//            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
//                mergedList.add(rightList.get(rightPoint));
//                rightPoint += 1;
//            } else {
//                mergedList.add(leftList.get(leftPoint));
//                leftPoint += 1;
//            }
//        }
//
//        // CASE2: right 데이터가 없을 때
//        while (leftList.size() > leftPoint) {
//            mergedList.add(leftList.get(leftPoint));
//            leftPoint += 1;
//        }
//
//        // CASE3: left 데이터가 없을 때
//        while (rightList.size() > rightPoint) {
//            mergedList.add(rightList.get(rightPoint));
//            rightPoint += 1;
//        }
//
//        return mergedList;
//    }
//
//    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
//        if (dataList.size() <= 1) {
//            return dataList;
//        }
//        int medium = dataList.size() / 2;
//
//        ArrayList<Integer> leftArr = new ArrayList<Integer>();
//        ArrayList<Integer> rightArr = new ArrayList<Integer>();
//
//        leftArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
//        rightArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));
//
//        return this.mergeFunc(leftArr, rightArr);
//    }
//
//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//
//        list.add(51);
//        list.add(15);
//        list.add(53);
//        list.add(55);
//        list.add(578);
//        list.add(5);
//
//    }
//}
