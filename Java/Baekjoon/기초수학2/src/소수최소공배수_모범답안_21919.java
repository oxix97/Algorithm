import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 소수최소공배수_모범답안_21919 {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[10000];
        long ans = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if (isPrimeNumber(arr[i])) {
                ans = lcm(ans, arr[i]);
            }
        }
        if (ans == 1) System.out.println(-1);
        else System.out.println(ans);
    }

    private static boolean isPrimeNumber(long x) {
        for (long i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    private static long gcd(long x, long y) {
        while (y != 0) {
            long tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    private static long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }
}
