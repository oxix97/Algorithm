package src.basic;

import java.util.*;
public class 소수찾기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int answer = 0;
        for(int i=1;i<=n;i++) {
            int num = scan.nextInt();
            int cont = 0;
            for(int j=1;j<=num;j++)
                if(num%j==0) cont++;
            if(cont==2) answer++;
        }
        System.out.println(answer);
    }
}
