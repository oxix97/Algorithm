import java.util.*;
public class 블랙젝 {
    public static int solution(int n, int m, int[] arr) {
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            int temp=0;
            for(int j=0;j<arr.length;j++) {
                if(j!=i) {
                    for(int k=0;k<arr.length;k++) {
                        if(k!=i && k!=j) {
                            temp = arr[i]+arr[j]+arr[k];
                            if(sum<temp && temp<=m) sum=temp;
                        }
                    }
                }
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scan.nextInt();
        System.out.println(solution(n,m,arr));
    }
}
