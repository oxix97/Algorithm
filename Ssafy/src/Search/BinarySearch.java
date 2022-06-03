package Search;

import Util.UtilClass;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {
        UtilClass util = new UtilClass();
        ArrayList<Integer> list = new ArrayList<>();

        util.inputRandomValue(list);
        Collections.sort(list);
        boolean isContain = binarySearch(list,100);
        System.out.println(isContain);
//        util.printIntegerList(list);
    }

    private static Boolean binarySearch(ArrayList<Integer> list, int findItem) {
        if (list.size() == 1) {
            return list.get(0) == findItem;
        }

        if (list.size() == 0)
            return false;

        int medium = list.size() / 2;
        if (findItem == list.get(medium)) {
            return true;
        } else {
            if (list.get(medium) > findItem) {
                return binarySearch(new ArrayList<>(list.subList(0, medium)), findItem);
            } else {
                return binarySearch(new ArrayList<>(list.subList(medium, list.size())), findItem);
            }
        }
    }
}
