package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오일러피함수_11689 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long N;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        N = Long.parseLong(br.readLine());
    }

    private static void solution() {
        long result = N;
        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                result -= result / i;
            }
            while (N % i == 0) N /= i;
        }
        if (N > 1) {
            result -= result / N;
        }
        sb.append(result);
    }

    private static void output() {
        System.out.print(sb.toString());
    }
}
