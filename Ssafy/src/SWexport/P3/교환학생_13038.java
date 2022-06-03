//package SWexport.P3;
//
//import java.util.Scanner;
//
//public class 교환학생_13038 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt();
//
//        for (int i = 1; i <= T; i++) {
//            int count = sc.nextInt();
//            int[] weekend = new int[7];
//            for (int j = 0; j < weekend.length; j++) {
//                weekend[j] = sc.nextInt();
//            }
//
//            int start = 0;
//            int day = 0;
//
//            for (int j = 0; j < weekend.length; j++) {
//                if (weekend[j] == 0)
//                    continue;
//                start = j;
//
//                while (count != 0) {
//                    ++start;
//                    ++day;
//                    if (weekend[start % 7] == 1) {
//                        --count;
//                    }
//                }
//            }
//            System.out.println("#" + i + " " + day);
//        }
//    }
//}
