import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2_10816 {
    static int N;
    static int M;
    static int[] nArr;
    static int[] mArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        mArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int lower = lowerBinarySearch(mArr[i]);
            int upper = upperBinarySearch(mArr[i]);
            sb.append(upper - lower).append(' ');
        }
        System.out.println(sb);

    }

    private static int lowerBinarySearch(int n) {
        int start = 0;
        int end = N;

        while (start < end) {
            int mid = (start + end) / 2;
            if (n <= nArr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int upperBinarySearch(int n) {
        int start = 0;
        int end = N;

        while (start < end) {
            int mid = (start + end) / 2;
            if (n < nArr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
