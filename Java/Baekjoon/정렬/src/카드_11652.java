import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드_11652 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static long[] arr;


    public static void main(String[] args) throws IOException {
        init();
        sorted();
    }

    static void sorted() {
        int cnt = 1, maxCnt = 1;
        long maxValue = arr[0];
        for (int i = 1; i < T; i++) {
            if (arr[i - 1] == arr[i]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxValue = arr[i];
            }
        }
        sb.append(maxValue);
        System.out.println(sb.toString());
    }

    static void init() throws IOException {
        T = Integer.parseInt(br.readLine());
        arr = new long[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
    }
}
