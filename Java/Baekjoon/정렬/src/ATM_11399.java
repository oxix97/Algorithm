import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM_11399 {
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
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void solution() {
        insertionSort();
        calculate();
    }

    private static void calculate() {
        int[] sum = new int[N];
        sum[0] = arr[0];
        answer = arr[0];

        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + arr[i];
            answer += sum[i];
        }
    }

    private static void insertionSort() {
        for (int i = 1; i < N; i++) {
            int idx = i;
            int value = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    idx = j + 1;
                    break;
                }
                if (j == 0) { //제일 작은 수
                    idx = 0;
                }
            }

            for (int j = i; j > idx; j--) {
                arr[j] = arr[j - 1];
            }
            arr[idx] = value;
        }
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}
