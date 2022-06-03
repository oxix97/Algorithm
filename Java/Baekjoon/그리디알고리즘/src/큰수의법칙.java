import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 큰수의법칙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int K = Integer.parseInt(inputs[2]);
        br.readLine();

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(arr);

        int first = arr[arr.length - 1];
        int second = arr[arr.length - 2];
        int cnt = 0;
        int sum = 0;
        for (int i = 1; i <= M; i++) {
            if (cnt == K) {
                sum += second;
                cnt = 0;
            } else {
                sum += first;
                ++cnt;
            }
        }
        System.out.println(sum);
    }
}
