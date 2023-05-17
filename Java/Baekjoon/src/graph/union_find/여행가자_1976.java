package src.graph.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자_1976 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M; // N개 도시, M개 여행 계획에 속한 도시
    static int[][] courses; // 여행 코스
    static int[] plan;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        courses = new int[N + 1][N + 1];
        plan = new int[M + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                courses[i][j] = Integer.parseInt(st.nextToken());
            }
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (courses[i][j] == 1)
                    union(i, j);
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    private static int find(int a) {
        if (a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }

    private static void output() {
        System.out.print(isConnected() ? "YES" : "NO");
    }

    private static boolean isConnected() {
        int idx = find(plan[1]);
        for (int i = 2; i <= M; i++) {
            if (idx != find(plan[i])) {
                return false;
            }
        }
        return true;
    }
}
