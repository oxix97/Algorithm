package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 칵테일_1033 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static ArrayList<Node>[] abpq; // a / b = p / q
    static boolean[] visited;
    static long[] recipe;
    static int lcm = 1;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        recipe = new long[N];
        visited = new boolean[N];
        abpq = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            abpq[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            abpq[a].add(new Node(b, p, q));
            abpq[b].add(new Node(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
        recipe[0] = lcm;
    }

    private static long gcd(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        if (min == 0) return a;
        return gcd(min, max % min);
    }

    private static void solution() {
        dfs(0);

        long v = recipe[0];
        for (int i = 1; i < N; i++) {
            v = gcd(recipe[i], v);
        }

        for (long n : recipe)
            sb.append(n / v).append(' ');
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        for (Node node : abpq[idx]) {
            if (!visited[node.idx]) {
                visited[node.idx] = true;
                recipe[node.idx] = recipe[idx] * node.q / node.p;
                dfs(node.idx);
            }
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    static class Node {
        int idx;
        int p;
        int q;

        public Node(int idx, int p, int q) {
            this.idx = idx;
            this.p = p;
            this.q = q;
        }
    }
}

