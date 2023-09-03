package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] room;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 - 동 - 남 - 서
    static int answer = 1;

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
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        robot(r, c, d);
        System.out.println(answer);
        br.close();
    }

    private static void robot(int r, int c, int d) {
        room[r][c] = -1;
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + move[d][0];
            int nc = c + move[d][1];
            if (exceptionRange(nr, nc)) continue;

            if (room[nr][nc] == 0) {
                ++answer;
                robot(nr, nc, d);
                return;
            }
        }

        // 청소 불가능 한 경우
        int b = (d + 2) % 4;
        int nr = r + move[b][0];
        int nc = c + move[b][1];
        if (!exceptionRange(nr, nc) && room[nr][nc] != 1) {
            robot(nr, nc, d);
        }
    }

    private static boolean exceptionRange(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= M;
    }
}
