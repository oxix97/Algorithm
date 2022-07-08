import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {
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

        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(mArr[i]));
        }
    }

    private static int binarySearch(int n) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (n > nArr[mid]) {
                start = mid + 1;
            } else if (n < nArr[mid]) {
                end = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
