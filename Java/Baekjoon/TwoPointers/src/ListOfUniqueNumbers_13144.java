import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    static void solution2() {
        int L= 1, R = 0;
        long ans = 0;

        while (L <= N) {

        }
    }

    private static void solution() {
        int L = 1, R = 2;
        long ans = 0;


        if (arr.length == 2) {
            sb.append(1);
            return;
        }
        while (L <= R && L < N) {
            if (arr[L] != arr[R]) {
                ++ans;
                ++R;
                if (R > N) {
                    ++L;
                    R = L + 1;
                }
            } else {
                ++L;
                R = L + 1;

            }
        }
        ans += N;
        sb.append(ans);
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
