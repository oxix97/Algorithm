package src.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int M, N;
    static int[][] box;
    static Queue<Integer> q;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리

        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.add(i);
                    q.add(j);
                }
            }
        }

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (isException(ny, nx)) {
                    continue;
                }
                if (box[ny][nx] == 0) {
                    box[ny][nx] = box[y][x] + 1;
                    q.add(ny);
                    q.add(nx);
                }
            }
        }

        int answer = checkTomatoes();
        System.out.println(answer); // 기존에 토마토에서 + 1씩 증가했으므로 초기 토마토 값 1 제거
        br.close();
    }

    private static int checkTomatoes() {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
                answer = Math.max(answer, box[i][j]);
            }
        }
        return answer - 1;
    }

    private static boolean isException(int ny, int nx) {
        if (ny < 0 || nx < 0 || ny >= N || nx >= M) return true;
        return box[ny][nx] != 0;
    }
}
