package src.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해_21736 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static final int[][] MOVE = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int answer;

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
        campus = new char[N][M];
        visited = new boolean[N][M];
        int[] doyeon = new int[2];

        //캠퍼스 입력
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                campus[i][j] = input[j];
                if (input[j] == 'I') {
                    doyeon[0] = i;
                    doyeon[1] = j;
                }
            }
        }

        //출발
        dfs(doyeon[0], doyeon[1]);

        if (answer == 0) System.out.println("TT");
        else System.out.println(answer);
        br.close();
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        if (campus[y][x] == 'P') ++answer;

        for (int[] move : MOVE) {
            int ny = y + move[0];
            int nx = x + move[1];
            if (outOfCampus(ny, nx) || campus[ny][nx] == 'X') continue;
            if (visited[ny][nx]) continue;
            dfs(ny, nx);
        }
    }

    private static boolean outOfCampus(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= N || nx >= M;
    }
}
