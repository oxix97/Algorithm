import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기_2230 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        int R = 1, min = Integer.MAX_VALUE;
        for (int L = 1; L <= N; L++) {
            while (R < N && arr[R] - arr[L] < M) {
                R++;
            }
            if (arr[R] - arr[L] >= M)
                min = Math.min(arr[R] - arr[L], min);
        }
        sb.append(min);
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, 1, N + 1);
    }
}
