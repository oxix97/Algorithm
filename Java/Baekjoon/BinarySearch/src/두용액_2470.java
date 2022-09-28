import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static long[] arr;
    static long a, b;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        inputs();
        outputs();
        sb.append(a).append(' ').append(b);
        System.out.println(sb.toString());
    }

    private static void outputs() {
        for (int i = 0; i < T - 1; i++) {
            //binarySearch에 넣은 수의 반대값에 가장 가까운수를 구하는게 목표
            binarySearch(i + 1, T - 1, -arr[i]);
        }
    }

    private static void binarySearch(int L, int R, long num) {
        int mid = 0;
        while (L <= R) {
            mid = (L + R) / 2;
            if (num > arr[mid]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        //다시 원래대로 변경
        num *= -1;
        long result = Math.abs(num + arr[mid]);
        if (result < ans) {
            ans = result;
            if (num < arr[mid]) {
                a = num;
                b = arr[mid];
            } else {
                a = arr[mid];
                b = num;
            }
        }
    }

    private static void inputs() throws IOException {
        T = Integer.parseInt(br.readLine());
        arr = new long[T];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}
