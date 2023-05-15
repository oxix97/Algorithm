package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 제곱ㄴㄴ수_1016 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long MIN, MAX;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        MIN = Long.parseLong(st.nextToken());
        MAX = Long.parseLong(st.nextToken());
        arr = new boolean[(int) (MAX - MIN) + 1];
    }

    private static void solution() {
        checkSquareNumber();
        countNotSquareNumber();
    }

    private static void countNotSquareNumber() {
        long cnt = 0;
        for (int i = 0; i <= (int) (MAX - MIN); i++) {
            if (!arr[i]) ++cnt;
        }
        sb.append(cnt);
    }

    private static void checkSquareNumber() {
        for (long i = 2; i * i <= MAX; i++) {
            long pow = i * i;
            long start = MIN / pow;

            if (MIN % pow != 0) ++start;

            for (long j = start; j * pow <= MAX; j++) {
                arr[(int) ((j * pow) - MIN)] = true;
            }
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }
}
