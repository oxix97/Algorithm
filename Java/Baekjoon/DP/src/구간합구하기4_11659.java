import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기4_11659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int[] sumArr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() throws IOException {
        createSumArr(); // 합배열 생성
        calculate(); // 주어진 구간에 맞는 값을 도출한다.
    }

    private static void calculate() throws IOException {
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = sumArr[y] - sumArr[x - 1];

            if (x == y) sb.append(arr[y]).append('\n');
            else sb.append(sum).append('\n');
        }

    }

    private static void createSumArr() {
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    //N : 배열 길이 ,M : 질의 개수를 입력 받는다.
    //주어진 배열을 입력받는다.
    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        sumArr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}