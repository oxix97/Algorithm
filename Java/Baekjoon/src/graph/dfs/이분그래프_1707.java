package src.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분그래프_1707 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int K, V, E;  // 테스트 케이스 개수 2...5, 정점 개수 1...20,000, 간선 개수 1...200,000
    static boolean[] visited;
    static int[] check; //0, 1 그룹으로 나누는 역할
    static ArrayList<Integer>[] list;
    static boolean isBinary; // dfs반복을 더이상 해야 하는지 확인하는 역할

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        for (int i = 1; i <= K; i++) { // K만큼 반복
            inputs();
            solution();
        }
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[V + 1];
        check = new int[V + 1];
        list = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[v].add(e);
            list[e].add(v);
        }

        isBinary = true;
    }

    private static void solution() {
        for (int i = 1; i <= V; i++) {
            if (!isBinary) break;
            dfs(i);
        }
        appendVertical(isBinary ? "YES" : "NO");
    }

    private static void dfs(int n) {
        visited[n] = true;

        for (int nx : list[n]) {
            if (!visited[nx]) {
                check[nx] = (check[n] + 1) % 2;
                dfs(nx);
            } else if (check[n] == check[nx]) {
                isBinary = false;
            }
        }
    }

    private static void output() {
        System.out.print(sb);
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}
