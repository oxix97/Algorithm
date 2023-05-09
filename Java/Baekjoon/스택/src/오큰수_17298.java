import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {
    //1. 각 입력값들의 파라미터 정리 N : 수열 크기,
    //2. 시간복잡도, 공간복잡도 계산 O(N)
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] nums;
    static Stack<Integer> stack;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void solution() {
        stack.push(0);//1. 스택 1개 채우기
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {//2. 인덱스를 비교하기
                answer[stack.pop()] = nums[i];     //3. 인덱스 비교하고 큰 수가 들어오는 경우 pop
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {                  //4. 남은 인덱스는 오큰수 -> -1로 변환
            answer[stack.pop()] = -1;
        }
    }

    private static void output() {
        for (int n : answer) {
            sb.append(n).append(' ');
        }
        System.out.println(sb.toString());
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        answer = new int[N];
        stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
