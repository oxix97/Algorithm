import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NQueen_9663 {
    static int N, ans;
    static int[] col;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        initial();
        recursion(1);
        sb.append(ans);
        System.out.println(sb.toString());
    }

    private static void initial() throws IOException {
        N = Integer.parseInt(br.readLine());
        col = new int[N + 1];
    }

    static void recursion(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int i = 1; i <= N; i++) {
                boolean possible = true;
                for (int j = 1; j <= row - 1; j++) {
                    if (attackable(row, i, j, col[j])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = i;
                    recursion(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    static boolean attackable(int row, int i, int j, int col) {
        if (i == col) return true;
        if (row - i == j - col) return true;
        if (row + i == j + col) return true;
        return false;
    }
}
