package src.basic;

import java.util.*;
public class 베르트랑공준 {
    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[2*n+1];
        arr[1] = 1;
        int i=0, j=0;
        for(i=2;i<=n*2;i++)
            for(j=2;i*j<=n*2;j++)
                arr[i*j]=1;
        for(i=n+1;i<arr.length;i++)
            if(arr[i]!=1) answer++;
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int n = scan.nextInt();
            if(n==0) return;
            else System.out.println(solution(n));
        }
    }
}
