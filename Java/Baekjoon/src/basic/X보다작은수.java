package src.basic;

import java.util.*;
public class X보다작은수 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int num = scan.nextInt();
        for(int i=1;i<=n;i++){
            int x = scan.nextInt();
            if(num>x)
                System.out.println(x);
        }
    }
}
