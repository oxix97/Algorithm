package src.basic;

import java.util.*;
public class 벌집 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long temp = 1;
        int answer = 1;
        for(long i=1;temp<n;i++) {
            temp += (6*i);
            answer++;
        }
        System.out.println(answer);
    }
}
