package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_3085 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static char[][] arr;
    static HashMap<Character, Integer> map;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] candies = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = candies[j];
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, recursion(i, j));
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static int recursion(int i, int j) {
        int A = swapCount(i, j, i + 1, j);
        int B = swapCount(i, j, i, j + 1);
        return Math.max(A, B);
    }

    private static int swapCount(int y, int x, int ny, int nx) {
        if (exceptionCheck(ny, nx)) return 0;
        swap(y, x, ny, nx);
        int cnt = count();
        swap(ny, nx, y, x);
        return cnt;
    }

    private static int count() {
        int result = 0;

        for (int i = 0; i < N; i++) {
            int c1 = 1, c2 = 1;
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) ++c1;
                else c1 = 1;
                result = Math.max(result, c1);
            }
            for (int j = 0; j < N - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) ++c2;
                else c2 = 1;
                result = Math.max(result, c2);
            }
        }
        return result;
    }

    private static void swap(int y, int x, int ny, int nx) {
        char tmp = arr[y][x];
        arr[y][x] = arr[ny][nx];
        arr[ny][nx] = tmp;
    }


    private static boolean exceptionCheck(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= N || nx >= N;
    }
}
