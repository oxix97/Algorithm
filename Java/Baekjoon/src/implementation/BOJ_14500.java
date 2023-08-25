package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static final int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int answer;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        //2. 시간복잡도, 공간복잡도 계산 -> 250,000 * 64 < 1억 미만

        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        /*
            1. 입력값 받고
            2. 테크도미노 ㅜ 모양을 제외하고 전부 dfs로 가능
            3. 예외 모양 따로 check
        * */
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
                checkOther(i, j);
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void checkOther(int y, int x) {
        if (y <= N - 2 && x <= M - 1)
            answer = Math.max(answer, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x + 1]);

        if (y <= N - 2 && x > 1)
            answer = Math.max(answer, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x - 1]);

        if (y <= N - 1 && x <= M - 2)
            answer = Math.max(answer, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y + 1][x + 1]);

        if (y > 1 && x <= M - 2)
            answer = Math.max(answer, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y - 1][x + 1]);
    }

    private static void dfs(int y, int x, int cnt, int sum) {
        if (cnt >= 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int[] next : move) {
            int ny = y + next[0];
            int nx = x + next[1];
            if (checkExceptions(ny, nx)) continue;
            if (visited[ny][nx]) continue;
            visited[ny][nx] = true;
            dfs(ny, nx, cnt + 1, sum + arr[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    private static boolean checkExceptions(int y, int x) {
        return y > N || x > M || y < 1 || x < 1;
    }
}
