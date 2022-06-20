import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은구간_1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < L - 1; i++) {
            if (arr[i] < N && arr[i + 1] > N) {
                int start = arr[i] + 1;
                int end = arr[i + 1] - 1;

                for (int j = start; j <= end; j++) {
                    for (int k = j; k <= end; k++) {
                        if (k < N) continue;
                        if (j == k || j > N) continue;
                        ++cnt;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
