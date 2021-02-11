import java.util.*;
public class 덩치 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n  = scan.nextInt();
        int[][] check = new int[n][2];
        int[] answer = new int[n];
        for(int i=0;i<n;i++)
            answer[i] = 1;

        for(int i=0;i<n;i++) {
            check[i][0] = scan.nextInt();
            check[i][1] = scan.nextInt();
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(check[i][0]<check[j][0]) {
                    if(check[i][1]<check[j][1]) answer[i]++;
                }
            }
        }
        for(int i=0;i<n;i++) {
            if(i==n-1)
                System.out.print(answer[i]);
            else
                System.out.print(answer[i]+" ");
        }
    }
}
