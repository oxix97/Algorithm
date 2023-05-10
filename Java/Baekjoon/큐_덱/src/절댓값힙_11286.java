import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절댓값힙_11286 {
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
    static int[] nums;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void solution() {
        initialQueue();
        for (int i = 1; i <= N; i++) {
            if (nums[i] == 0) {
                if (queue.isEmpty())
                    append(0);
                else
                    append(queue.poll());
            } else {
                queue.add(nums[i]);
            }
        }
    }

    private static void append(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void initialQueue() {
        queue = new PriorityQueue<>((x, y) -> {
            int abs1 = Math.abs(x);
            int abs2 = Math.abs(y);

            if (abs1 == abs2) {
                return x > y ? 1 : -1;
            } else
                return abs1 - abs2;
        });
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    }
}
