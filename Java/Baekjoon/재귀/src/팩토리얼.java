import java.util.*;
public class 팩토리얼 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long mul = 1;
        for(int i=1;i<=n;i++)
            mul*=i;
        System.out.println(mul);
    }
}
