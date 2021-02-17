import java.util.*;
public class 약수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scan.nextInt();
        Arrays.parallelSort(arr);
        System.out.println(arr[0] * arr[n-1]);
    }
}
