package src.basic;

import java.util.*;
public class 윤년 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int y = scan.nextInt();
        if(y%4==0){
            if(y%100==0 && y%400 != 0) System.out.println(0);
            else System.out.println(1);
        }
        else System.out.println(0);
    }
}
