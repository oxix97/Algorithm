package src.graph.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드_11404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] distances;
    static final int INF = 987654321; //간선(100) * 노드(100,000) -> 10^7이상 SOF 안나게 유동적으로

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distances = new int[N + 1][N + 1];

        // 배열 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    distances[i][j] = 0;
                } else distances[i][j] = INF;
            }
        }
        // 가중치 입력
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distances[a][b] = Math.min(distances[a][b], c);
        }

        // 점화식으로 배열 업데이트
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (distances[i][j] == INF) distances[i][j] = 0;
                sb.append(distances[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
