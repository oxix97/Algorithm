import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 버블소트프로그램1_1377 {
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
    static Number[] nums;
    static int answer;
    static int[] test;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void solution() {
        Arrays.sort(nums); // 1. 입력받은 배열 정렬

        for (int i = 0; i < N; i++) { // 2. 초기에 할당된 인덱스와 정렬 이후 인덱스 차이가 가장 큰 값 -> 반복 회수
            answer = Math.max(answer, nums[i].idx - i);
        }
    }

    private static void output() {
        System.out.println(answer + 1); // 버블소트에서 아무런 변화가 없는 것을 체크하기 위해서 1번은 더 돌기 때문에 + 1
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new Number[N];

        for (int i = 0; i < N; i++) {
            nums[i] = new Number(i, Integer.parseInt(br.readLine()));
        }
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}

class Number implements Comparable<Number> {
    int idx, value;

    public Number(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    @Override
    public int compareTo(Number n) {
        return this.value - n.value;
    }
}
