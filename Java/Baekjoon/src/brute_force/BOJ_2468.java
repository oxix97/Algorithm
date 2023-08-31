package src.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 안전 영역
public class BOJ_2468 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static final int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int h = 1; h <= 100; h++) {
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] < h) visited[i][j] = true;
                }
            }

            int tmp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    dfs(i, j);
                    ++tmp;
                }
            }
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
        br.close();
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int[] next : move) {
            int ny = i + next[0];
            int nx = j + next[1];
            if (exceptionRange(ny, nx) || visited[ny][nx]) continue;
            dfs(ny, nx);
        }
    }

    private static boolean exceptionRange(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= N || nx >= N;
    }
}
