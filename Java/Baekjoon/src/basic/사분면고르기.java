package src.basic;

import java.util.*;
public class 사분면고르기 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if(a>=0){
            if(b>=0) System.out.println(1);
            else System.out.println(4);
        }
        else{
            if(b>=0) System.out.println(2);
            else System.out.println(3);
        }
    }
}
