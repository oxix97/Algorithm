import java.util.*;
public class 소인수분해 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int i = 2;
        while(n/i > 0 && i<=n) {
            if(n%i==0) {
                System.out.println(i);
                n/=i;
                i=1;
            }
            i++;
        }
    }
}
