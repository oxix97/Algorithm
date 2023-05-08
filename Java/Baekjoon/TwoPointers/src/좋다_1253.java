import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
    //1. 각 입력값들의 파라미터 정리 / 입력값 n : 1..2000, 배열 arr, arr[i] : 1..10억
    //2. 시간복잡도, 공간복잡도 계산 / 2초(2억) O(n^2) 4천만
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void solution() {
        //1.배열 정렬
        //2.맨 끝부터 idx을 정한다음 해당 타겟이 목표값이 되는 투포인터 알고리즘
        //3. target이 존재하면 ++answer이후 반복문 종료
        //4. left >= right가 되면 전부 탐색을 한 것이므로 반복문 종료 이후 정답 출력.
        Arrays.sort(arr, 1, N + 1);
        for (int idx = 1; idx <= N; idx++) {
            int left = 1;
            int right = N;
            long target = arr[idx];

            while (left < right) {
                long sum = arr[left] + arr[right];
                if (sum == target) {
                    if (left == idx) {
                        ++left;
                        continue;
                    }
                    if (right == idx) {
                        --right;
                        continue;
                    }
                    ++answer;
                    break;
                } else if (sum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
