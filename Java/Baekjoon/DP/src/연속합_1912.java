import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합_1912 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            recursion(i);
        }
        Arrays.sort(arr);
        System.out.println(arr[N - 1]);
    }

    private static void recursion(int i) {
        if (arr[i] + arr[i - 1] > arr[i]) {
            arr[i] += arr[i - 1];
        }
    }
}
