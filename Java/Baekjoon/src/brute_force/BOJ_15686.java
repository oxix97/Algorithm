package src.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> house = new ArrayList<>();
    static boolean[] open;
    static int answer = 100_000;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) house.add(new Node(i, j));
                else if (arr[i][j] == 2) chicken.add(new Node(i, j));
            }
        }
        open = new boolean[chicken.size()];

        dfs(0, M);
        System.out.println(answer);
        br.close();
    }

    private static void dfs(int idx, int m) {
        if (m == 0) {
            int sum = 0;
            for (Node h : house) {
                int dist = 100_000;
                int i = 0;
                for (Node c : chicken) {
                    if (!open[i++]) continue;
                    dist = Math.min(dist, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
                }
                sum += dist;
            }
            answer = Math.min(answer, sum);
        }

        for (int i = idx; i < open.length; i++) {
            open[i] = true;
            dfs(i + 1, m - 1);
            open[i] = false;
        }
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
