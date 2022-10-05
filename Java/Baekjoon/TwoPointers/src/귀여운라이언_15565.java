import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 귀여운라이언_15565 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K, target = 1;
    static int[] arr;
    //라이언 인형 1 , 어피치 인형 2

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        int R = 0, ans = N + 1, cnt = 0;
        for (int L = 1; L <= N; L++) {
            while (R < N && cnt < K) {
                if (arr[++R] == 1) {
                    ++cnt;
                }
            }
            if (cnt == K) {
                ans = Math.min(ans, R - L + 1);
            }
            if (arr[L] == 1) cnt--;
        }
        if (ans == N + 1) ans = -1;
        sb.append(ans);
    }


    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
