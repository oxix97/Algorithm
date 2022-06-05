import java.util.Arrays;
import java.util.Scanner;

public class 유기농배추_1012 {
    static int[][] ground;
    static int T;
    static int N;
    static int M;
    static int K;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            input();
            output();
        }
    }

    private static void output() {
        int cnt = 0;
        for (int i = 0; i < ground.length; i++) {
            for (int j = 0; j < ground[i].length; j++) {
                if (dfs(i, j)) ++cnt;
            }
        }
        System.out.println(cnt);
    }


    private static boolean dfs(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N) return false;

        if (ground[x][y] == 1) {
            ground[x][y] = 0;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    private static void input() {
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        ground = new int[M][N];

        for (int[] ints : ground) {
            Arrays.fill(ints, 0);
        }

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ground[x][y] = 1;
        }
    }
}
