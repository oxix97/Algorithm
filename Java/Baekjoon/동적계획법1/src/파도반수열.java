import java.util.*;
public class 파도반수열 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[101];
        arr[0]=0;
        for(int i=1;i<=3;i++) arr[i] = 1;
        for(int i=4;i<=5;i++) arr[i] = 2;
        for(int i=6;i<=100;i++)
            arr[i] = arr[i-5] + arr[i-1];
        for(int i=1;i<=n;i++) {
            int num = scan.nextInt();
            System.out.println(arr[num]);
        }
    }
}
