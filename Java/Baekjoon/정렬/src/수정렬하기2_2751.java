import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수정렬하기2_2751 {
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
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solution() {
        mergedSort(0, N - 1);
    }

    private static void mergedSort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergedSort(left, mid); // 정복
        mergedSort(mid + 1, right); // 정복
        merge(left, mid, right); // 결합
    }

    private static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int l;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) sorted[k++] = arr[i++];
            else sorted[k++] = arr[j++];
        }

        if (i > mid) {
            for (l = left; l <= right; l++) {
                sorted[k++] = arr[l];
            }
        } else {
            for (l = i; l <= mid; l++) {
                sorted[k++] = arr[l];
            }
        }

        for (l = left; l <= right; l++) {
            arr[l] = sorted[l];
        }
    }

    private static void output() {
        for (int n : arr) {
            appendVertical(n);
        }
        System.out.println(sb.toString());
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}
