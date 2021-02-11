import java.util.*;
public class 최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int temp = n > m ? m : n;
        for(int i=temp;i>=1;i--) {
            if(n%i==0 && m%i==0){
                System.out.println(i);
                System.out.println(n*m/i); return;
            }
        }
    }
}
