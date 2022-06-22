import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 다리놓기_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            BigInteger a = BigInteger.valueOf(1);
            BigInteger b = BigInteger.valueOf(1);
            BigInteger result;
            for (int j = M; j > M - N; j--) {
                a = a.multiply(BigInteger.valueOf(j));
            }

            for (int j = 1; j <= N; j++) {
                b = b.multiply(BigInteger.valueOf(j));
            }
            result = a.divide(b);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}
