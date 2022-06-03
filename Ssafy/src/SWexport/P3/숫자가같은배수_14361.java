package SWexport.P3;

import java.util.ArrayList;
import java.util.Scanner;

public class 숫자가같은배수_14361 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            String N = String.valueOf(n);
            ArrayList<String> list = new ArrayList<>();

            for (int j = 0; j < N.length(); j++) {
                list.add(N.substring(j, j + 1));
            }

            String result = checker(N, list);
            System.out.println("#" + i + " " + result);
        }
    }

    static String checker(String n, ArrayList<String> list) {
        int cnt = 2;

        if (n.length() == 1) {
            return "impossible";
        }

        String num = String.valueOf((Integer.parseInt(n) * 2));
        while (num.length() == list.size()) {
            boolean check = true;

            for (int i = 0; i < list.size(); i++) {
                if (!list.contains(num.substring(i, i + 1))) {
                    check = false;
                    break;
                }
            }

            if (check && Integer.parseInt(num) > Integer.parseInt(n)) {
                return "possible";
            }

            num = String.valueOf((Integer.parseInt(n) * ++cnt));
        }

        return "impossible";
    }
}
