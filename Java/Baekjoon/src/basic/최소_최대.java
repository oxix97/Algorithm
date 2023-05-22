package src.basic;

import java.util.*;
public class 최소_최대 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++)
            arr[i] = scan.nextInt();
        Arrays.sort(arr);
        System.out.printf("%d %d\n",arr[0],arr[n-1]);
    }
}
