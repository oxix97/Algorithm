package src.graph.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기_11403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] G;
    static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리 , 입력값 n , 그래프 i,j G,
        N = Integer.parseInt(br.readLine());
        G = new int[N + 1][N + 1];

        // 배열 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (G[i][k] == 1 && G[k][j] == 1)
                        G[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(G[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
