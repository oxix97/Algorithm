import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 토너먼트_1057 {
    static int N;
    static int jimin;
    static int hansoo;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        jimin = Integer.parseInt(st.nextToken());
        hansoo = Integer.parseInt(st.nextToken());
        arr = new boolean[100001];
        Arrays.fill(arr, false);

        arr[jimin] = true;
        arr[hansoo] = true;
        int cnt = 1;

        while (true) {
            if (N % 2 == 1) ++N;

            for (int j = 1; j <= N; j += 2) {
                if (arr[j] && arr[j + 1]) {
                    System.out.println(cnt);
                    return;
                }
            }
            if (jimin % 2 == 1) ++jimin;
            if (hansoo % 2 == 1) ++hansoo;

            Arrays.fill(arr, false);
            jimin /= 2;
            hansoo /= 2;

            arr[jimin] = true;
            arr[hansoo] = true;

            N /= 2;
            ++cnt;
        }
    }
}
