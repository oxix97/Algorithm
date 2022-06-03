import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();

            if (N == 1) {
                System.out.println("#" + i + " " + 0);
                continue;
            }

            for (int j = 0; j < N; j++) {
                int temp1 = sc.nextInt();
                int temp2 = temp1 % 2;
                //짝수 0, 홀수 1
                list.add(temp2);
            }

            int min = 201;
            ArrayList<Integer> temp = new ArrayList<>(list);

            if (!list.contains(0)) {
                System.out.println("#" + i + " " + -1);
            } else if (!list.contains(1)) {
                System.out.println("#" + i + " " + -1);
            } else {
                for (int j = 0; j < temp.size(); j++) {
                    int cnt = 0;
                    temp = list;
                    for (int k = 0; k < temp.size() - 1; k++) {
                        if (temp.get(k).equals(temp.get(k + 1))) {
                            Collections.swap(temp, k, k + 1);
                            ++cnt;
                        }
                    }

                    min = Math.min(min, cnt);
                    temp.clear();
                }
                System.out.println("#" + i + " " + min);
            }
        }
    }
}
