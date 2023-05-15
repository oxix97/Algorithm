package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소공배수_1934 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T; // 입력 개수
    static int[][] inputs;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        T = Integer.parseInt(br.readLine());
        inputs = new int[T + 1][2];
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = Integer.parseInt(st.nextToken());
            inputs[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solution() {
        for (int i = 1; i <= T; i++) {
            int a = inputs[i][0];
            int b = inputs[i][1];
            int result = a * b / gcd(a, b);
            appendVertical(result);
        }
    }

    private static int gcd(int A, int B) {
        if (B == 0)
            return A;
        else
            return gcd(B, A % B);
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}
