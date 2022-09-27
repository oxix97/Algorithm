import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가_7795 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M, sum;
    static int[] nArr, mArr;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            init();
            binarySearch();
            sb.append(sum).append('\n');
            sum = 0;
        }
        System.out.println(sb.toString());
    }

    private static void binarySearch() {
        for (int i = 0; i < N; i++) {
            int L = 0, R = mArr.length - 1;
            while (L <= R) {
                int mid = (L + R) / 2;
                if (nArr[i] > mArr[mid]) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
            for (int j = 0; j <= R; j++) {
                sum += 1;
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nArr = new int[N];
        mArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mArr[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(mArr);
    }
}
