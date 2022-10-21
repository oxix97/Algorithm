import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            if (recursion(i)) {
                ++cnt;
            }
        }
        sb.append(cnt);
    }

    private static boolean recursion(int index) {
        int L = 1, R = index;
        while (L < R) {
            int mid = (L + R) / 2;
            int value = arr[index] - arr[mid];
            int rL = L, rR = mid, rMid = 0;
            while (L < mid) {
                rMid = (rL + rR) / 2;
                if (value - arr[rMid] > 0) {
                    rL = rMid + 1;
                } else if (value - arr[rMid] == 0) {
                    return true;
                } else {
                    rR = mid - 1;
                }
            }
            if (value - arr[rMid] > 0) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 1, N + 1);
    }
}
