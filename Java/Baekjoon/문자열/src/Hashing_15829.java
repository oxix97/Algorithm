import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing_15829 {
    static int L;
    static String str;
    static int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        str = br.readLine();
        long result = 0;

        for (int i = 0; i < L; i++) {
            int tmp = str.charAt(i) - 'a' + 1;
            result += funcHash(tmp, i);
        }
        System.out.println(result);
    }

    private static int funcHash(int tmp, int cnt) {
        final int num = (int) Math.pow(31, cnt);
        return (num * tmp) % M;
    }
}
