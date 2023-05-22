package src.basic;

import java.util.*;
public class 골드바흐의추측 {
    public static void solution(int n) {
        int[] arr = new int[2*n+1];
        arr[1] = 1;
        int i=0, j=0;
        for(i=2;i<=n;i++)
            for(j=2;i*j<=n;j++)
                arr[i*j]=1;
        int temp = n;
        String tt = null;
        for(i=1;i<arr.length;i++) {
            try {
                if(arr[i]!=1 && arr[n-i]!=1) {
                    if(temp>(n-i*2) && n-i*2>=0) {
                        temp = n-i*2;
                        tt = i+" "+ (n-i);
                    }
                }
            }catch(IndexOutOfBoundsException e) {
                System.out.println(tt);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=1;i<=n;i++) {
            int input = scan.nextInt();
            solution(input);
        }
    }
}
