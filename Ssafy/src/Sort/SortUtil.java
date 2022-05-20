package Sort;

import java.util.ArrayList;

public class SortUtil {

    public ArrayList<Integer> inputRandomValue(ArrayList<Integer> list) {
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 100 + 1));
        }
        return list;
    }

    public void printList(ArrayList<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
