import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        int R = 0, sum = 0, ans = N + 1;

        for (int L = 1; L <= N; L++) {
            sum -= arr[L - 1];

            while (R + 1 <= N && sum < S) {
                //S값을 넘을때 까지 R 이동
                sum += arr[++R];
            }
            if (sum >= S) {
                ans = Math.min(ans, R - L + 1);
            }
        }
        if (ans == N + 1) {
            ans = 0;
        }
        sb.append(ans);
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
