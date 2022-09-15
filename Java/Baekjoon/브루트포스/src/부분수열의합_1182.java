import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_1182 {
    static int N, S, ans;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        recursion(1, 0);
        if (S == 0) {
            //공집합 제거
            ans--;
        }
        sb.append(ans);
        System.out.println(sb.toString());
    }

    static void recursion(int count, int value) {
        if (count == N + 1) {
            if (value == S) ans++;
        } else {
            //해당 원소를 포함하고 넘어 가는 과정
            recursion(count + 1, value + arr[count]);
            //해당 원소를 미포함하고 넘어 가는 과정
            recursion(count + 1, value);
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
