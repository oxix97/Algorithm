package src.graph.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙_1389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리 / N(100) 유저 수, M(5,000) 친구 관계 수
        // A, B로 이루어진 M개 친구관계 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //배열 생성 및 초기화
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF;
                if (i == j) arr[i][j] = 0;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A][B] = 1;
            arr[B][A] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int sum = INF;
        int idx = 1;
        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == INF) arr[i][j] = 0;
                tmp += arr[i][j];
            }
            if (sum > tmp) {
                sum = tmp;
                idx = i;
            }
        }
        System.out.println(idx);
        br.close();
    }
}
