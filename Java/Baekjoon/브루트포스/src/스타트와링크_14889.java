import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크_14889 {
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[21][21];
        visit = new boolean[21][21];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                recursion(i, j, 1, 0);
            }
        }
        System.out.println(ans);
    }

    private static void recursion(int i, int j, int cnt, int sum) {
        if (cnt > N / 2) {
            ans = Math.min(sum, ans);
            return;
        }
        sum += Math.abs(arr[i][j] - arr[j][i]);

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (x == y) continue;
                if (visit[i][j]) continue;
                recursion(y, x, cnt + 1, sum);
                visit[i][j] = false;
            }
        }
    }
}
