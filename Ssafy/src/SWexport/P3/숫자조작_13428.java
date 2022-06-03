//package SWexport.P3;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class 숫자조작_13428 {
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt();
//
//        for (int i = 1; i <= T; i++) {
//            Long num = sc.nextLong();
//            String sNum = String.valueOf(num);
//            ArrayList<String> list = new ArrayList<>();
//            for (int j = 0; j < sNum.length(); j++) {
//                list.add(sNum.substring(j, j + 1));
//            }
//
//            sb.append("#").append(i).append(' ');
//            minSwap(list);
//            sb.append(' ');
//            maxSwap(list);
//            sb.append('\n');
//        }
//        System.out.println(sb.toString());
//    }
//
//    private static void minSwap(ArrayList<String> list) {
//        int cnt = 0;
//        for (int i = 0; i < list.size(); i++) {
//            int min = i;
//            boolean swap = false;
//            for (int j = i + 1; j < list.size(); j++) {
//                if (((Long.parseLong(list.get(min)) > Long.parseLong(list.get(j))))) {
//                    if (i == 0 && Long.parseLong(list.get(j)) == 0)
//                        continue;
//                    ++cnt;
//                    swap = true;
//                    min = j;
//                }
//            }
//            if (swap) {
//                Collections.swap(list, i, min);
//                for (String item : list) {
//                    sb.append(item);
//                }
//                Collections.swap(list, min, i);
//                break;
//            }
//        }
//        if (cnt == 0) {
//            for (String item : list) {
//                sb.append(item);
//            }
//        }
//
//    }
//
//    private static void maxSwap(ArrayList<String> list) {
//        int cnt = 0;
//        for (int i = 0; i < list.size(); i++) {
//            int max = i;
//            boolean swap = false;
//            for (int j = i + 1; j < list.size(); j++) {
//                if (((Long.parseLong(list.get(max)) < Long.parseLong(list.get(j))))) {
//                    swap = true;
//                    ++cnt;
//                    max = j;
//                }
//            }
//            if (swap) {
//                Collections.swap(list, i, max);
//                for (String item : list) {
//                    sb.append(item);
//                }
//                break;
//            }
//        }
//        if (cnt == 0) {
//            for (String item : list) {
//                sb.append(item);
//            }
//        }
//    }
//}
