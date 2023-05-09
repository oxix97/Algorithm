import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택수열_1874 {
    //1. 각 입력값들의 파라미터 정리 N : 스택크기, 스택 연산 arr
    //2. 시간복잡도, 공간복잡도 계산 O(N)
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] input;
    static int num = 0;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void solution() {
        // 스택 초기 세팅
        // num  < input[i] -> push sb.append('+')  , num > input[i] pop sb.append('-')
        // 중간에 에러가 나면 NO 출력

        for (int i = 1; i <= N; i++) {
            if (num <= input[i]) { //push
                while (num != input[i])
                    pushStack();
                popStack();
            } else { //pop
                if (popStack() > input[i]) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    return;
                }
            }
        }
    }

    private static void pushStack() {
        stack.push(++num);
        sb.append('+').append('\n');
    }

    private static int popStack() {
        sb.append('-').append('\n');
        return stack.pop();
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
    }
}
