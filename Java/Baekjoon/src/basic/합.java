package src.basic;

import java.util.*;
public class 합 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int n = scan.nextInt();
        for(int i=1;i<=n;i++)
            sum+=i;
        System.out.println(sum);
    }
}
