import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 바닥장식_1388 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int width;
    static int height;
    static char[][] arr;
    static int cnt = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");

        height = Integer.parseInt(inputs[0]);
        width = Integer.parseInt(inputs[1]);
        arr = new char[height][width];
        input();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (dfs(j, i)) ++cnt;
            }
        }

        System.out.println(cnt);

    }

    private static boolean dfs(int w, int h) {
        if (w < 0 || w >= width || h < 0 || h >= height) {
            return false;
        }
        if (visited[h][w]) {
            return false;
        }

        visited[h][w] = true;

        if (arr[h][w] == '-' && (w == width - 1 || arr[h][w + 1] == '-')) {
            dfs(w + 1, h);
        } else if (arr[h][w] == '|' && (h == height - 1 || arr[h + 1][w] == '|')) {
            dfs(w, h + 1);
        }
        return true;
    }

    private static void input() throws IOException {
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < width; j++) {
                arr[i][j] = line[j];
            }
            Arrays.fill(visited[i], false);
        }
    }
}
