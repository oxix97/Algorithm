package src.basic;

import java.util.*;
public class 문자열반복 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0;i<n;i++) {
            int cont = scan.nextInt();
            String str = scan.next();
            for(int j=0;j<str.length();j++) {
                String temp = str.substring(j,j+1);
                for(int k=0;k<cont;k++)
                    System.out.print(temp);
            }
            System.out.println();
        }
    }
}
