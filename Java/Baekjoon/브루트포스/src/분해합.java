import java.util.*;
public class 분해합 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String temp = Integer.toString(n);
        int[] arr = new int[temp.length()];
        for(int i=n/2;i<n;i++){
            temp = Integer.toString(i);
            int tmp = Integer.parseInt(temp);
            for(int k=0;k<temp.length();k++){
                arr[k] = Integer.parseInt(temp.substring(k,k+1));
                tmp += arr[k];
            }
            if(tmp==n){
                System.out.println(temp); return;
            }
        }
        System.out.println(0);
    }
}
