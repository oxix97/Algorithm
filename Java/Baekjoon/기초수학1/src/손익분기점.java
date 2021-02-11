import java.util.*;
public class 손익분기점 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long fix = scan.nextLong();
        long var = scan.nextLong();
        long cost = scan.nextLong();
        long margin = cost-var;

        if(margin <=0)	System.out.println("-1");
        else {
            long n = fix/margin;
            n++;
            System.out.println(n);
        }
    }
}
