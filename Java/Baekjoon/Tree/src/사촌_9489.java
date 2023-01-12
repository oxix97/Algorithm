import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사촌_9489 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;
    static int[] parents;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if (N == 0 && K == 0) break;
            solution();
        }
    }

    private static void solution() {
        makeTree();
        findNumber();
    }

    private static void findNumber() {
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            if (inputs[i] == K) idx = i;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[parents[i]] == parents[parents[idx]] && parents[i] != parents[idx]) {
                ++answer;
            }

        }
        System.out.println(answer);
    }

    private static void makeTree() {
        parents[0] = -1;
        parents[1] = 0;
        int last = 1;

        for (int i = 2; i <= N; i++, last++) {
            for (; i <= N; i++) {
                parents[i] = last;
                if (i < N && inputs[i] + 1 != inputs[i + 1]) break;
            }
        }
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        inputs = new int[N + 1];
        parents = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) inputs[i] = Integer.parseInt(st.nextToken());
    }

}
