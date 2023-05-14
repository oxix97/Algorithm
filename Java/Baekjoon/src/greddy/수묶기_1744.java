package src.greddy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 수묶기_1744 {
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
    static PriorityQueue<Integer> plusQ;
    static PriorityQueue<Integer> minusQ;
    static int oneCnt;
    static int zeroCnt;
    static int sum;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        plusQ = new PriorityQueue<>(Collections.reverseOrder());
        minusQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n < 0)
                minusQ.add(n);
            else if (n > 1)
                plusQ.add(n);
            else if (n == 1)
                oneCnt++;
            else if (n == 0)
                zeroCnt++;
        }
    }

    private static void solution() {
        sumMinusQueue();
        sumPlusQueue();
        sumOthers();
    }

    private static void sumOthers() {
        if (!minusQ.isEmpty() && zeroCnt == 0) {
            sum += minusQ.poll();
        }
        sum += oneCnt;
        sb.append(sum);
    }

    private static void sumPlusQueue() {
        while (plusQ.size() > 1) {
            int a = plusQ.poll();
            int b = plusQ.poll();
            sum += (a * b);
        }

        if (plusQ.size() == 1) {
            sum += plusQ.poll();
        }
    }

    private static void sumMinusQueue() {
        while (minusQ.size() > 1) {
            int a = minusQ.poll();
            int b = minusQ.poll();
            sum += (a * b);
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }
}
