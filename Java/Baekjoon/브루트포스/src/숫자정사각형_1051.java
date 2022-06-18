import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자정사각형_1051 {
    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[50][50];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        if (N == 1 || M == 1) {
            System.out.println(1);
            return;
        }

        int min = Math.min(N, M) - 1;
        int target = 0;

        for (int i = 1; i <= min; i++) {
            target = Math.max(target, recursion(i));
        }

        System.out.println(target * target);
    }

    private static int recursion(int num) {
        boolean isSuccess = false;
        for (int i = 0; i < N - num; i++) {
            for (int j = 0; j < M - num; j++) {
                int target = arr[i][j];
                if (target == arr[i][j + num] && target == arr[i + num][j] && target == arr[i + num][j + num]) {
                    isSuccess = true;
                    break;
                }
            }
        }

        return isSuccess ? ++num : 1;
    }
}
