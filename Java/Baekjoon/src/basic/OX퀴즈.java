package src.basic;

import java.util.*;
public class OX퀴즈 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] answer = new int[n];
        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
            int point = 0;
            arr[i] = scan.next();
            int size = arr[i].length();
            for(int j=0;j<size;j++) {
                String temp = arr[i].substring(j, j+1);
                if(temp.equals("O"))
                    answer[i] += ++point;
                else
                    point=0;
            }
        }
        for(int i=0;i<answer.length;i++)
            System.out.println(answer[i]);
    }
}
