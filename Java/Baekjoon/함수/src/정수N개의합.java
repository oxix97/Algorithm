import java.util.*;
public class 정수N개의합 {
    long sum(int[] a) {
        long ans = 0;
        for(int i=0;i<a.length;i++)
            ans+=a[i];
        return ans;
    }

    public static void main(String[] args) {
        정수N개의합 ssum = new 정수N개의합();
        int[] arr = {3,6,5,4};
        System.out.println(ssum.sum(arr));
    }
}
