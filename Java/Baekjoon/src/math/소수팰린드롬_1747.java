package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수팰린드롬_1747 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new boolean[10_000_001];
        arr[1] = true;
    }

    private static void solution() {
        selectPrimeNumber();
        for (int i = N; i <= 10_000_000; i++) {
            if (arr[i]) continue;
            String str = String.valueOf(i);
            if (str.equals(new StringBuffer(str).reverse().toString())) {
                sb.append(str);
                break;
            }
        }
    }

    private static void selectPrimeNumber() {
        for (int i = 2; i <= 10_000_000; i++) {
            for (int j = i + i; j <= 10_000_000; j += i) {
                arr[j] = true;
            }
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }
}
