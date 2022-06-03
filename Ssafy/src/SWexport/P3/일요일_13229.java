package SWexport.P3;

import java.util.Scanner;

public class 일요일_13229 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String[] arr = {"", "SAT", "FRI", "THU", "WED", "TUE", "MON", "SUN"};

        for (int i = 1; i <= T; i++) {
            String str = sc.next();

            for (int j = 1; j <= 7; j++) {
                if (str.equals(arr[j])) {
                    System.out.println("#" + i + " " + j);
                }
            }
        }
    }
}