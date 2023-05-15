package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거의소수_1456 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long A, B; // 1<=A<=B<=10^14 -> long
    static boolean[] arr; //내부 값은 10^7 -> int

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new boolean[(int) Math.sqrt(B) + 1];
    }

    private static void solution() {
        selectPrimeNumbers(); // B에 해당되는 소수 구하기
        checkPrimeNumbers(); // A~B에 범위에 있는 소수의 N제곱 수의 개수 구하기
    }

    private static void checkPrimeNumbers() {
        int cnt = 0;
        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (arr[i]) continue;
            long tmp = i;
            while ((tmp *= i) <= B) {
                if (tmp >= A) ++cnt;
                if (checkOverflow(i, tmp)) break;
            }
        }
        sb.append(cnt);
    }

    private static boolean checkOverflow(long a, long b) {
        return String.valueOf(a).length() + String.valueOf(b).length() > 15;
    }

    private static void selectPrimeNumbers() {
        arr[1] = true;
        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (arr[i]) continue;
            for (int j = i + i; j <= Math.sqrt(B); j += i) {
                arr[j] = true;
            }
        }
    }

    private static void output() {
        System.out.println(sb.toString());
    }
}
