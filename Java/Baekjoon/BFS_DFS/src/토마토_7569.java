import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, H;
    static int[][][] box;
    static int[][][] dist;
    static int[][] moves = {
            {0, 0, -1}, {0, 0, 1},
            {0, 1, 0}, {0, -1, 0},
            {1, 0, 0}, {-1, 0, 0}
    };

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
//        outputTest();
    }

    private static void outputTest() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {

                }
            }
        }
    }

    private static int countDays() {
        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (dist[i][j][k] == -1 && box[i][j][k] == 0) {
                        return -1;
                    }
                    answer = Math.max(dist[i][j][k], answer);
                }
            }
        }
        return answer;
    }

    private static void solution() {
        bfs();
        System.out.println(countDays());
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 1) {
                        q.add(i);
                        q.add(j);
                        q.add(k);
                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int z = q.poll();
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < moves.length; i++) {
                int nz = z + moves[i][0];
                int ny = y + moves[i][1];
                int nx = x + moves[i][2];

                if (bfsException(nz, ny, nx)) continue;

                dist[nz][ny][nx] = dist[z][y][x] + 1;
                q.add(nz);
                q.add(ny);
                q.add(nx);
            }
        }
    }

    private static boolean bfsException(int nz, int ny, int nx) {
        if (nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M) return true;
        if (dist[nz][ny][nx] != -1) return true;
        return box[nz][ny][nx] != 0;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dist = new int[H][N][M];
        box = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    dist[i][j][k] = -1;
                }
            }
        }
    }
}
