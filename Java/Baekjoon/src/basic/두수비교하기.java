package src.basic;

import java.util.*;
public class 두수비교하기 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if(a>b) System.out.println(">");
        else if(a==b) System.out.println("==");
        else System.out.println("<");
    }
}
