import java.util.Arrays;
import java.util.Scanner;

public class 전쟁_전투_1303 {
    static Scanner sc = new Scanner(System.in);
    static int width;
    static int height;
    static boolean[][] visited;
    static String[][] field;
    static int count = 0;
    static int W = 0;
    static int B = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        input();
        output();
    }

    private static void dfs(int x, int y, String target) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx < 0 || nx >= width || ny < 0 || ny >= height) continue;
            if (visited[ny][nx]) continue;
            if (!field[ny][nx].equals(target)) continue;

            ++count;
            dfs(nx, ny, target);
        }
    }

    private static void output() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j]) {
                    count = 1;
                    dfs(j, i, field[i][j]);
                    if (field[i][j].equals("W")) {
                        W += (int) (Math.pow(count, 2));
                    } else {
                        B += (int) (Math.pow(count, 2));
                    }
                }
            }
        }
        System.out.println(W + " " + B);
    }

    private static void input() {
        width = sc.nextInt(); //가로
        height = sc.nextInt(); // 세로
        field = new String[height][width];
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            String line = sc.next();
            for (int j = 0; j < width; j++) {
                field[i][j] = line.substring(j, j + 1);
            }
        }
        for (boolean[] i : visited) {
            Arrays.fill(i, false);
        }
        sc.close();
    }
}
