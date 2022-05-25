package Greedy;

import java.util.*;

public class 보물p1026 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> A;
    static ArrayList<Integer> B;
    static int N;

    public static void main(String[] args) {
        N = sc.nextInt();
        int result = 0;
        A = inputValue(new ArrayList<>());
        B = inputValue(new ArrayList<>());

        Collections.sort(A);
        Collections.sort(B);
        Collections.reverse(B);

        for (int i = 0; i < N; i++) {
            result += (A.get(i) * B.get(i));
        }
        System.out.println(result);
    }

    public static ArrayList<Integer> inputValue(ArrayList<Integer> list) {
        for (int i = 0; i < N; i++) {
            int item = sc.nextInt();
            list.add(item);
        }
        return list;
    }
}
