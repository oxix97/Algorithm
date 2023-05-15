package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_1929 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M; // M이상 N 이하의 범위 지정 <= 100_000
    static boolean[] arr; // arr.length <=100,000 , Integer

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1];
    }

    private static void solution() {
        for (int i = 2; i <= Math.sqrt(N); i++) {
            // N이 a*b라고 하는 경우 a,b 모두 sqrt(N)보다 큰 약수를 가질 수 없기 때문
            // 1 * 16, 2 * 8, 4 * 4, 8 * 2, 16 * 1
            // 대칭성을 보이며 이는 중간까지만 검사해도 전체를 검사할 수 있음을 증명한다.
            if (arr[i]) continue;
            for (int j = 4; j <= N; j++) {
                if (j % i == 0) {
                    arr[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!arr[i]) appendVertical(i);
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }
}
