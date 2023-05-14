package src.greddy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드정렬하기_1715 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static PriorityQueue<Integer> q;
    static int N;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
    }

    @SuppressWarnings("ConstantConditions")
    private static void solution() {
        int a = 0;
        int b = 0;
        int sum = 0;
        while (q.size() != 1) {
            a = q.poll();
            b = q.poll();
            sum += a + b;
            q.add(a + b);
        }
        sb.append(sum);
    }

    private static void output() {
        System.out.print(sb.toString());
    }

}
