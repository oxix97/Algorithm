import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소평균_21920 {
    static int N;
    static long[] arr;
    static int X;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[500001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());

        long sum = 0;

        for (int i = 1; i <= N; i++) {
            if (gcd(X, arr[i]) == 1) {
                sum += arr[i];
                ++cnt;
            }
        }

        System.out.printf("%.6f", (double) sum / cnt);
    }

    private static long gcd(long x, long y) {
        while (y != 0) {
            long tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}
