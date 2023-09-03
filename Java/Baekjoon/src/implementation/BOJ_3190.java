package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3190 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K, L;
    static int[][] board;
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static ArrayList<int[]> snake;
    static HashMap<Integer, String> map;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        map = new HashMap<>();
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y][x] = 1;
        }
        L = Integer.parseInt(br.readLine());

        for (int i = 1; i <= L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            map.put(x, c);
        }

        int y = 1, x = 1, d = 0, answer = 0;
        snake = new ArrayList<>();
        snake.add(new int[]{1, 1});

        for (int t = 1; t <= 10_000; t++) {
            //뱀 이동
            int ny = y + move[d][0];
            int nx = x + move[d][1];

            // 벽 유무, 자기 자신
            if (isFinish(ny, nx)) {
                answer = t;
                break;
            }

            // 사과 유무
            snake.add(new int[]{ny, nx});
            if (board[ny][nx] == 1) board[ny][nx] = 0;
            else snake.remove(0);

            //방향 전환
            if (map.containsKey(t)) {
                String direction = map.get(t);
                if (direction.equals("D")) d = (d + 1) % 4;
                else d = (d + 3) % 4;
            }

            y = ny;
            x = nx;
        }

        System.out.println(answer);
        br.close();
    }

    private static boolean isFinish(int ny, int nx) {
        if (ny <= 0 || nx <= 0 || ny > N || nx > N) return true;
        for (int[] s : snake) {
            if (s[0] == ny && s[1] == nx) return true;
        }
        return false;
    }
}
