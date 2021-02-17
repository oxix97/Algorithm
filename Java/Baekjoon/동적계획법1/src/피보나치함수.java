import java.util.*;
public class 피보나치함수 {
    public static void solution(int num){
        int[][] arr = new int[num+2][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;
        int i;
        if(num<=1){
            System.out.println(arr[num][0] +" "+arr[num][1]); return;
        }
        for(i=2;i<arr.length;i++){
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }
        System.out.println(arr[num][0]+" "+arr[num][1]);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=1;i<=n;i++){
            int num = scan.nextInt();
            solution(num);
        }
    }
}
