import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽_1940 {
    //1. 각 입력값들의 파라미터 정리 / n,m, arr
    //2. 시간복잡도, 공간복잡도 계산 / 2초 2억번 연산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지  / 투포인터 알고리즘
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        //1. arr배열 오름차순 정렬
        //2. left=1,right=N 지정하여 목표값과 대조 하며 포인터 이동
        //3. left>=right 되면 탐색완료 이므로 종료 -> 결과 출력

        Arrays.sort(arr);
        int left = 1;
        int right = N;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (M == sum) {
                ++answer;
                ++left;
            } else if (M > sum) {
                ++left;
            } else {
                --right;
            }
        }
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
