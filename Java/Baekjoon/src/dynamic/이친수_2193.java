package src.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수_2193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] P;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        P = new long[91];

        P[1] = 1;
        P[2] = 1;
        P[3] = 2;

        for (int i = 4; i <= N; i++) {
            P[i] = P[i - 1] + P[i - 2];
        }

        System.out.println(P[N]);
        br.close();
    }
}
