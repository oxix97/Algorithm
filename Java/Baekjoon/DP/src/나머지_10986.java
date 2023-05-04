import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지_10986 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static long[] arr;
    static long[] sumArr;
    static long answer = 0;
    static long[] remainder;
    //N : 배열 길이(1~10^6), M(2~10^3) : 부분합을 나눌 값
    //arr : 기본 배열(value : 0~10^9), sumArr : 합배열

    public static void main(String[] args) throws IOException {
        inputs(); // N,M,기본 배열을 입력받은 뒤 합배열을 만든다.
        solution();
        output();
    }

    private static void solution() {
        step1(); // 합배열을 M으로 나누고 나온 나머지들의 개수를 구한다.0이면 ++answer;
        step2(); // 나머지가 동일한 인덱스중 2개를 뽑는 경우의 수를 구한다.(동일한 나머지가 2개인 경우->M으로 나누면 0)
        sb.append(answer);
    }

    private static void step2() {
        for (int i = 0; i < M; i++) {
            if (remainder[i] > 1) {
                answer = answer + (remainder[i] * (remainder[i] - 1) / 2);
            }
        }
    }

    private static void step1() {
        for (int i = 1; i <= N; i++) {
            int n = (int) (sumArr[i] % M);
            ++remainder[n];
            if (n == 0) ++answer;
        }
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        sumArr = new long[N + 1];
        remainder = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
    }
}
