package src.graph.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신기한소수_2023 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;

/* docs
* 1. 1의 자리 소수는 2,3,5,7 이므로 1의 자리부터 검사한다.
* 2. cnt==N 이 되면 마지막으로 소수 검사를 한 다음에 통과하면 요구사항에 맞는 소수를 찾았으니 sb.append 해준다.
*/
    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    private static void solution() {
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int n, int cnt) {
        if (N == cnt) {
            if (isPrimeNumber(n)) {
                appendVertical(n);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) continue;
            int v = (n * 10) + i;
            if (isPrimeNumber(v)) {
                dfs(v, cnt + 1);
            }
        }
    }

    private static boolean isPrimeNumber(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}
