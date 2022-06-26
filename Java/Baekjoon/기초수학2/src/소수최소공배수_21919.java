import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 소수최소공배수_21919 {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[10000];
        HashSet<Long> list = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (check(arr[i])) {
                list.add(arr[i]);
            }
        }

        long sum = 1;

        if (list.size() == 0) {
            sum = -1;
        } else {
            for (long i : list) {
                sum *= i;
            }
        }
        System.out.println(sum);
    }

    private static boolean check(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
