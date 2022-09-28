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
    static int[] arr;
    static int a = 0, b = 0;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        inputs();
        outputs();
        sb.append(a).append(' ').append(b);
        System.out.println(sb.toString());
    }

    private static void outputs() {
        for (int i = 0; i < T - 1; i++) {
            int candidate = binarySearch(i + 1, T - 1, -arr[i]);

            // A[candidate - 1] 와 A[candidate] 중에 A[left] 와 섞었을 때의 정보를 정답에 갱신시킨다.

            // 1. A[left] + A[candidate - 1]
            if (i < candidate - 1 && Math.abs(arr[i] + arr[candidate - 1]) < ans) {
                ans = Math.abs(arr[i] + arr[candidate - 1]);
                a = arr[i];
                b = arr[candidate - 1];
            }

            // 2. A[left] + A[candidate]
            if (i < candidate && Math.abs(arr[i] + arr[candidate]) < ans) {
                ans = Math.abs(arr[i] + arr[candidate]);
                a = arr[i];
                b = arr[candidate];
            }

        }
    }

    private static int binarySearch(int L, int R, int num) {
        int res = R;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }

    private static void inputs() throws IOException {
        T = Integer.parseInt(br.readLine());
        arr = new int[T];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}
