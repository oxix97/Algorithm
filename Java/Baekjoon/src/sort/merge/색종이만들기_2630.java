package src.sort.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기_2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] square;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //1. N( <= 128) -> N * N 사각형 , square[i] = 0 or 1
        //입력 값 받기
        N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //색상이 같지 않다면 4등분
        partition(0, 0, N);
        sb.append(white).append('\n').append(blue);
        System.out.println(sb);
        br.close();
    }

    private static void partition(int i, int j, int size) {
        if (colorCheck(i, j, size)) {
            if (square[i][j] == 0) ++white;
            else ++blue;
            return;
        }
        int newSize = size / 2;

        partition(i, j, newSize);
        partition(i + newSize, j, newSize);
        partition(i, j + newSize, newSize);
        partition(i + newSize, j + newSize, newSize);
    }

    private static boolean colorCheck(int y, int x, int size) {
        int target = square[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (target != square[i][j]) return false;
            }
        }
        return true;
    }
}
