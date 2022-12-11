import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;
    static int[] arr = new int[100_001];
    final static int MAX_VALUE = 100_000;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        bfs();
        System.out.println(arr[K]);

    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        arr[N] = 0;

        while (!q.isEmpty()) {
            int n = q.poll();
            if (n == K) break;

            if (n + 1 <= MAX_VALUE && arr[n + 1] == Integer.MAX_VALUE) {
                q.add(n + 1);
                arr[n + 1] = Math.min(arr[n + 1], (arr[n] + 1));
            }
            if (n - 1 >= 0 && arr[n - 1] == Integer.MAX_VALUE) {
                q.add(n - 1);
                arr[n - 1] = Math.min(arr[n - 1], (arr[n] + 1));
            }
            if (n * 2 <= MAX_VALUE && arr[n * 2] == Integer.MAX_VALUE) {
                q.add(n * 2);
                arr[n * 2] = Math.min(arr[n * 2], arr[n] + 1);
            }
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, Integer.MAX_VALUE);
    }

}
