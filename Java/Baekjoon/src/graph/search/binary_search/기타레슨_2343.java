package src.graph.search.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int max;
    static int sum;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
    }

    private static void solution() {
        int left = max;
        int right = sum;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isOk(mid)) left = mid + 1;
            else right = mid - 1;
        }
        appendVertical(left);
    }

    private static boolean isOk(int capacity) {
        int cnt = 1;
        int tmp = capacity;
        for (int i = 0; i < N; i++) {
            if (tmp - arr[i] < 0) {
                ++cnt;
                tmp = capacity;
            }
            tmp -= arr[i];
        }
        return cnt > M;
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}
