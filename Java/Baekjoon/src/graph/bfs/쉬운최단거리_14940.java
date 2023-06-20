package src.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_14940 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] dist;
    static int[][] inputs;
    static int[][] calc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inputs = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];
        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
                if (inputs[i][j] == 2) {
                    y = i;
                    x = j;
                }
            }
        }

        bfs(y, x);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && inputs[i][j] == 1)
                    dist[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        inputs[y][x] = 0;
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int ny = q.poll();
            int nx = q.poll();

            for (int i = 0; i < 4; i++) {
                int cy = calc[i][0] + ny;
                int cx = calc[i][1] + nx;

                if (checkException(cy, cx)) continue;
                if (visited[cy][cx]) continue;

                dist[cy][cx] = dist[ny][nx] + 1;
                visited[cy][cx] = true;
                q.add(cy);
                q.add(cx);
            }
        }
    }

    private static boolean checkException(int cy, int cx) {
        if (cy < 0 || cx < 0 || cy >= N || cx >= M) {
            return true;
        }
        if (inputs[cy][cx] == 0) {
            return true;
        }
        if (dist[cy][cx] >= 1) {
            return true;
        }
        return false;
    }
}
