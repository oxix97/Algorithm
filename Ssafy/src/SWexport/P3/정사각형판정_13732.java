//package SWexport.P3;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class 정사각형판정_13732 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt();
//        ArrayList<String> list;
//
//        for (int i = 0; i < T; i++) {
//            String answer = "no";
//            int N = sc.nextInt();
//            String str = sc.nextLine();
//            list = new ArrayList<>();
//
//            for (int j = 0; j < N; j++) {
//                list.add(str.substring(j, j + 1));
//            }
//
//            int width = 0;
//            for (int j = 0; j < list.get(i).length(); j++) {
//
//                if (list.get(j).equals("#")) {
//                    ++width;
//                    if (j > 0 && j < list.get(i).length() - 1) {
//                        if (list.get(j - 1).equals(".") && list.get(j + 1).equals(".")) width = 0;
//                    }
//                }
//            }
//            int height = 0;
//
//            for (int j = 1; j < list.get(i).length() - 1; j++) {
//                if (list.get(j - 1).equals(list.get(j))) {
//                    ++height;
//                }
//            }
//            if (width == height) answer = "yes";
//
//            System.out.println("#" + i + 1 + " " + answer);
//        }
//
//    }
//}
