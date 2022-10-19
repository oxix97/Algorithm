import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이만들기_2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        recursion(0, 0, N);
        sb.append(white).append('\n').append(blue);
    }

    private static void recursion(int x, int y, int size) {
        if (colorCheck(x, y, size)) {
            if (arr[x][y] == 0) {
                ++white;
            } else {
                ++blue;
            }
            return;
        }

        int newSize = size / 2;
        recursion(x, y, newSize); // 1
        recursion(x + newSize, y, newSize); // 2
        recursion(x, y + newSize, newSize); // 3
        recursion(x + newSize, y + newSize, newSize); // 4
    }

    private static boolean colorCheck(int x, int y, int size) {
        int color = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
