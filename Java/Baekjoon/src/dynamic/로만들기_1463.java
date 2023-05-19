package src.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 로만들기_1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] X;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        X = new int[1000001];
        X[1] = 0;
        X[2] = 1;
        X[3] = 1;

        for (int i = 4; i <= N; i++) {
            X[i] = X[i - 1] + 1;
            if (i % 2 == 0) X[i] = Math.min(X[i], X[i / 2] + 1);
            if (i % 3 == 0) X[i] = Math.min(X[i], X[i / 3] + 1);
        }

        System.out.println(X[N]);
        br.close();
    }
}
