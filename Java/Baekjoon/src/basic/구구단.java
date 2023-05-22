package src.basic;

import java.util.*;
public class 구구단 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=1;i<=9;i++)
            System.out.printf("%d * %d = %d\n",n,i,n*i);
    }
}
