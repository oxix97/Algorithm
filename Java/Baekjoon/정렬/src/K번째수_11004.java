import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수_11004 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void solution() {
        quickSort(arr, 0, N - 1);
        sb.append(arr[K - 1]);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;

        int mid = partition(a, left, right);
        quickSort(a, left, mid - 1);
        quickSort(a, mid, right);
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[(left + right) / 2];

        while (left <= right) {
            while (a[left] < pivot) left++;
            while (a[right] > pivot) right--;

            if (left <= right) {
                swap(a, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] a, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }


    private static void output() {
        System.out.println(sb.toString());
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
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
