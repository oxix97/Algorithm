import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기_1018 {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Boolean[][] arr = new Boolean[50][50];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) == 'W';
            }
        }

        int min = Integer.MAX_VALUE;
        int w = M - 7;
        int h = N - 7;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                min = Math.min(solution(j, i, arr), min);
            }
        }
        System.out.println(min);
    }

    private static int solution(int w, int h, Boolean[][] arr) {
        int cnt = 0;
        int endX = w + 8;
        int endY = h + 8;
        boolean target = arr[h][w];

        for (int i = h; i < endY; i++) {
            for (int j = w; j < endX; j++) {
                if (arr[i][j] == target) {
                    ++cnt;
                }
                target = !target;
            }
            target = !target;
        }

        cnt = Math.min(cnt, 64 - cnt);
        return cnt;
    }
}
