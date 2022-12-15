import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_3055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C;
    static char[][] arr;
    static int[] S = {0, 0};
    static int[] D = {0, 0};
    static int[][] waterDist;
    static int[][] biberDist;
    static int[][] move = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
//        outputTest(waterDist);
//        System.out.println("--------");
//        outputTest(biberDist);
    }

    private static void outputTest(int[][] dist) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    sb.append('W').append(' ');
                else
                    sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
        sb = new StringBuilder();
    }

    private static void output() {
        int result = biberDist[D[0]][D[1]];
        if (result == -1)
            sb.append("KAKTUS");
        else
            sb.append(result);

        System.out.println(sb.toString());
    }

    private static void solution() {
        waterSpread();
        findBiber();
    }

    private static void findBiber() {
        Queue<Integer> q = new LinkedList<>();
        q.add(S[0]);
        q.add(S[1]);
        biberDist[S[0]][S[1]] = 0;

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < move.length; i++) {
                int ny = y + move[i][0];
                int nx = x + move[i][1];

                if (biberException(ny, nx)) continue;
                if (biberDist[y][x] + 1 >= waterDist[ny][nx]) continue;
                q.add(ny);
                q.add(nx);

                biberDist[ny][nx] = biberDist[y][x] + 1;
            }
        }
    }

    private static boolean biberException(int y, int x) {
        if (y < 0 || x < 0 || y >= R || x >= C) return true;
        if (biberDist[y][x] != -1) return true;
        if (arr[y][x] == 'X' || arr[y][x] == '*') return true;
        return false;
    }

    private static void waterSpread() {
        Queue<Integer> q = new LinkedList<>();
        waterDist[D[0]][D[1]] = (R * C) + 1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '*') {
                    q.add(i);
                    q.add(j);
                    waterDist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < move.length; i++) {
                int ny = y + move[i][0];
                int nx = x + move[i][1];

                if (waterException(ny, nx)) continue;

                q.add(ny);
                q.add(nx);

                waterDist[ny][nx] = waterDist[y][x] + 1;
            }
        }
    }

    private static boolean waterException(int y, int x) {
        if (y < 0 || x < 0 || y >= R || x >= C) return true;
        if (arr[y][x] != '.') return true;
        if (waterDist[y][x] != -1) return true;
        return false;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        waterDist = new int[R][C];
        biberDist = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line[j];
                if (arr[i][j] == 'D') {
                    D[0] = i;
                    D[1] = j;
                } else if (arr[i][j] == 'S') {
                    S[0] = i;
                    S[1] = j;
                }
            }
            Arrays.fill(waterDist[i], -1);
            Arrays.fill(biberDist[i], -1);
        }
    }
}
