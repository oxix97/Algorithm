import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 탈출_3055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C;
    static char[][] arr;
    static int[] S = {0, 0};
    static int[] D = {0, 0};
    static int[][] dist;
    static int answer = Integer.MAX_VALUE;
    static int[][] move = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };


    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        //현 위치 초기화
        int y = S[0];
        int x = S[1];
        dist[y][x] = 0;

        //물 흐르게 하고

        for (int i = 0; i < Math.max(R, C); i++) {
            spreadWater();
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (dist[y][x] != -1)
                        moveS(j, k);
                }
            }
        }

        //고슴도치 이동


        int resultY = D[0];
        int resultX = D[1];

        if (dist[resultY][resultX] == -1)
            sb.append("KAKTUS");
        else
            sb.append(dist[resultY][resultX]);

//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                sb.append(dist[i][j]).append(' ');
//            }
//            sb.append('\n');
//        }
//
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                sb.append(arr[i][j]).append(' ');
//            }
//            sb.append('\n');
//        }
        System.out.println(sb.toString());
    }

    private static void spreadWater() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '*') {
                    moveWater(i, j); // 물주는거
                }
            }
        }
    }

    private static void moveS(int y, int x) {
        for (int i = 0; i < move.length; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];

            if (moveException(ny, nx)) continue;
            dist[ny][nx] = dist[y][x] + 1;
        }
    }

    private static boolean moveException(int y, int x) {
        if (y < 0 || x < 0 || y >= R || x >= C) return true;
        return arr[y][x] != '.' && arr[y][x] != 'D';
    }

    private static void moveWater(int y, int x) {
        for (int i = 0; i < move.length; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];

            if (spreadException(ny, nx)) continue;

            arr[ny][nx] = '*';
        }
    }

    private static boolean spreadException(int y, int x) {
        if (y < 0 || x < 0 || y >= R || x >= C) return true;
        return arr[y][x] != '.';
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        dist = new int[R][C];

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
            Arrays.fill(dist[i], -1);
        }
    }
}
