import java.io.*;
import java.math.*;
import java.util.*;
public class Number_1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        BigInteger n = new BigInteger(tokenizer.nextToken());
        BigInteger m = new BigInteger(tokenizer.nextToken());

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}
