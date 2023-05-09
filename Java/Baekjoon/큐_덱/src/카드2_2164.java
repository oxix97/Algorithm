import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드2_2164 {
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
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void solution() {
        initialQueue();//1. 큐에 N만큼 넣는다.

        if (q.size() == 1) { //2. q.poll(), q.poll() q.add() 반복
            sb.append(q.poll());
        } else if (q.size() == 2) {
            q.poll();
            sb.append(q.poll());
        } else {
            shuffle();
            sb.append(q.poll());
        }
    }

    private static void shuffle() {
        while (q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }
    }

    private static void initialQueue() {
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
    }
}
