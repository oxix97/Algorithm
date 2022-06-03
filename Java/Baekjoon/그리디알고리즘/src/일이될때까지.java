import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이될때까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        int cnt = 0;

        while (N != 1) {
            if (N % K == 0)
                N /= K;
            else
                N -= 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
