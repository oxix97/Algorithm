import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 일곱난쟁이_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            list.add(num);
        }

        int tmp;
        for (int i = 0; i < 9; i++) {
            tmp = sum;
            int item = list.remove(0);
            tmp -= item;
            for (int j = 0; j < 8; j++) {
                if (tmp - list.get(j) == 100) {
                    list.remove(j);
                    Collections.sort(list);
                    for (int k : list)
                        System.out.println(k);
                    return;
                }
            }
            list.add(item);
        }
    }
}
