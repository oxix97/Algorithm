import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합_3273 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, target;
    static int ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        binarySearch();
        sb.append(ans);
        System.out.println(sb.toString());
    }

    private static void binarySearch() {
        for (int j = 0; j < N - 1; j++) {
            if (calc(j + 1, N - 1, target - arr[j])) ans++;
        }
    }

    private static boolean calc(int L, int R, int item) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == item) return true;
            if (item > arr[mid]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        target = Integer.parseInt(br.readLine());
        Arrays.sort(arr, 0, N);
    }

}
