import java.util.*;
public class 평균 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double sum = 0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scan.nextInt();
        Arrays.sort(arr);
        int temp = arr[n-1];
        for(int i=0;i<arr.length;i++)
            sum += (double)(arr[i]*100)/temp;
        System.out.println((double)sum/n);
    }
}
