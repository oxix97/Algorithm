import java.util.*;
public class 소수구하기 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int front = scan.nextInt();
        int back = scan.nextInt();
        int[] arr = new int[back+1];
        int i=0,j=0;
        arr[1] = 1;
        for(i=2;i<=back;i++)
            for(j=2;i*j<=back;j++)
                arr[i*j]=1;
        for(i=front;i<arr.length;i++)
            if(arr[i]!=1) System.out.println(i);
        scan.close();
    }
}
