import java.util.*;
public class 이항계수_1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = {1,1};
        for(int i=m;i>=1;i--){
            arr[0] *= n--;
            arr[1] *= i;
        }
        System.out.println(arr[0]/arr[1]);
    }
}
