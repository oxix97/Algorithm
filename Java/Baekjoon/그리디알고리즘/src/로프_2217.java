import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프_2217 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int cnt = 1;
        int max = 0;
        for (int i = N; i >= 1; i--) {
            int tmp = arr[i] * cnt;
            if (max <= tmp)
                max = tmp;
            cnt++;
        }
        System.out.println(max);
    }
}
