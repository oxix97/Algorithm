import java.util.*;
public class 셀프넘버 {
    public static int dNum(int value){
        int sum = 0;
        sum += value;
        while(value != 0){
            sum += (value%10);
            value /= 10;
        }
        return sum;
    }
    public static void main(String[] args){
        int[] arr1 = new int[10000];
        for(int i=0; i<arr1.length;i++)
            arr1[i] = dNum(i);
        Arrays.sort(arr1);

        int[] arr2 = new int[10001];
        for(int i=0;i<arr2.length;i++)
            arr2[i] = i;

        for(int i=0;i<arr2.length;i++){
            int stack = 0;
            for(int j=0;j<arr1.length;j++){
                if(arr2[i]==arr1[j]){
                    stack ++; break;
                }
            }
            if(stack==0)
                System.out.println(arr2[i]);
        }
    }
}
