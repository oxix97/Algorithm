package src.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static boolean[][] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new boolean[101][101];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int y = b; y < b + 10; y++) {
                for (int x = a; x < a + 10; x++) {
                    if (arr[y][x]) continue;
                    arr[y][x] = true;
                    ++answer;
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
