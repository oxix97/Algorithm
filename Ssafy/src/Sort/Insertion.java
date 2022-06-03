package Sort;

import Util.UtilClass;

import java.util.ArrayList;
import java.util.Collections;

public class Insertion {
    public static void main(String[] args) {
        UtilClass util = new UtilClass();
        ArrayList<Integer> list = new ArrayList<>();
        util.inputRandomValue(list);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (list.get(j - 1) > list.get(j)) {
                    Collections.swap(list,j,j-1);
                }else{
                    break;
                }
            }
        }

        util.printIntegerList(list);
    }
}
