import java.util.*;
public class 링 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scan.nextInt();
        for(int i=1;i<n;i++) {
            int temp = arr[0] > arr[i] ? arr[i] : arr[0];
            for(int j=temp;j>=1;j--) {
                if(arr[0]%j==0 && arr[i]%j==0) {
                    System.out.println(arr[0]/j+"/"+arr[i]/j); break;
                }
            }
        }
    }}
