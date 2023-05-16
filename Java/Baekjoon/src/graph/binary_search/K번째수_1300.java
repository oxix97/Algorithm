package src.graph.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수_1300 {
    //1. 각 입력값들의 파라미터 정리 N <= 10^5 ,K <= 10^9
    //2. 시간복잡도, 공간복잡도 계산 O(NlogN)
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long N, K;
    static long answer;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
    }

    private static void solution() {
        long left = 1;
        long right = K; // K번째 수의 값은 K보다 클 수 없다. -> B[K] <= K

        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt < K) { // cnt값이 K 보다 작으면 B[K] > mid
                left = mid + 1;
            } else {        // cnt값이 K 보다 크거나 같으면 B[K] <= mid
                answer = mid;
                right = mid - 1;
            }
        }
    }

    private static void output() {
        System.out.println(answer);
    }
}
