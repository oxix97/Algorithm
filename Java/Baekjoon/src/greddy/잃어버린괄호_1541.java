package src.greddy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호_1541 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] line;
    static int plus = 0;
    static int minus = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        line = br.readLine().split("-");
    }

    private static void solution() {
        for (int i = 0; i < line.length; i++) {
            if (i == 0) plus = calculate(i);
            else minus += calculate(i);
        }
    }

    private static int calculate(int idx) {
        int sum = 0;
        for (String s : line[idx].split("[+]")) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    private static void output() {
        System.out.println(plus - minus);
    }
}
