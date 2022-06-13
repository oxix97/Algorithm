import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수삼각형_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];


        for (int[] i : arr) {
            Arrays.fill(i, -1);
        }

        //input
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
//            if (i != N)
//                br.readLine();
        }

        for (int i = N; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                int item = Math.max(arr[i][j], arr[i][j + 1]);
                arr[i - 1][j] += item;
            }
        }

        System.out.println(arr[1][1]);
    }
}
