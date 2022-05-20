package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class Selection {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        SortUtil util = new SortUtil();
        util.inputRandomValue(list);

        int lowest;
        for (int i = 0; i < list.size() - 1; i++) {
            lowest = i;
            for (int j = i + 1; j < list.size() - 1; j++) {
                if (list.get(lowest) > list.get(j)) {
                    lowest = j;
                }
            }
            Collections.swap(list, lowest, i);
        }

        util.printList(list);
    }
}
