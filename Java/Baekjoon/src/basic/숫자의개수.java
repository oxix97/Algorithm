package src.basic;

import java.util.*;
public class 숫자의개수 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int sum = a*b*c;
        int[] arr = new int[10];
        String str = Integer.toString(sum);
        for(int i=0;i<str.length();i++){
            int temp = Integer.parseInt(str.substring(i, i+1));
            arr[temp]++;
        }
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
