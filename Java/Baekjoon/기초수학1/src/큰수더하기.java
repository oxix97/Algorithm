import java.math.BigInteger;
import java.util.*;
public class 큰수더하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();

        scanner.close();

        System.out.println(a.add(b));
    }
}
