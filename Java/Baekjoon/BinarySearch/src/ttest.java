import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ttest {
    static int[] input1 = {1, 2, 3, 3, 3, 3, 4, 4};
    static int[] input2 = {3, 2, 4, 4, 2, 5, 2, 5, 5};
    static int[] input3 = {3, 5, 7, 9, 1};


    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        for (int i : input3) {
            input.add(i);
        }

        HashSet<Integer> set = new HashSet<>(input);

        if (set.size() == input.size()) {
            System.out.println(Arrays.asList(-1));
            return;
        }

        List<Integer> tmp = new ArrayList<>(set);

        ArrayList<Integer> answer = new ArrayList();
        for (int i = 0; i < tmp.size(); i++) {
            int item = tmp.get(i);
            int cnt = 0;
            for (int k : input) {
                if (item == k) ++cnt;
            }
            if (cnt > 1) answer.add(cnt);
        }
        System.out.println(answer);
    }
}
