package src.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조약돌꺼내기_13251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int M, K;
    static int[] inputs;
    static double sum = 0.0;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        M = Integer.parseInt(br.readLine());
        inputs = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
            sum += inputs[i];
        }
        K = Integer.parseInt(br.readLine());

        double result = 0.0;

        for (int i = 0; i < M; i++) {
            int n = inputs[i];
            result += calc(n);
        }
        System.out.println(result);

        br.close();
    }

    private static double calc(double n) {
        double result = 1.0;
        for (int i = 0; i < K; i++) {
            result *= (n - i) / (sum - i);
        }
        return result;
    }
}
