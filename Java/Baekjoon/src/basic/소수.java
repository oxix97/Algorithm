package src.basic;

import java.util.*;
public class 소수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int front = scan.nextInt();
        int back = scan.nextInt();
        int sum = 0;
        int cont = 0;
        int min = 0;
        for(int i=front;i<=back;i++) {
            int count = 0;
            for(int j=1;j<=i;j++)
                if(i%j==0)
                    count++;
            if(count==2) {
                if(cont==0) {
                    cont++;
                    min=i;
                }
                sum+=i;
            }
        }
        if(sum==0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
