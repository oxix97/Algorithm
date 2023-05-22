package src.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Hashing_15829 {
    static int L;
    static String str;
    static int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        str = br.readLine();
        BigInteger result = new BigInteger("0");

        for (int i = 0; i < L; i++) {
            int tmp = str.charAt(i) - 96;
            result = result.add(funcHash(tmp, i));
        }
        System.out.println(result.remainder(BigInteger.valueOf(M)));
    }

    private static BigInteger funcHash(int tmp, int cnt) {
        final BigInteger num = BigInteger.valueOf(31).pow(cnt);
        return num.multiply(BigInteger.valueOf(tmp));
    }
}
