import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부동산다툼_20364 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, Q;
    static int[] ducks;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.print(sb);
    }

    private static void solution() {

        for (int i = 1; i <= Q; i++) {
            int answer = 0;
            int tmp = ducks[i];
            while (tmp != 1) {
                if (visited[tmp]) {
                    answer = tmp;
                    break;
                }
                tmp /= 2;
            }
            if (answer == 0) {
                System.out.println("땅 먹음 : "+ducks[i]);
                visited[ducks[i]] = true;
            }

            sb.append(answer).append('\n');
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        ducks = new int[Q + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= Q; i++) {
            ducks[i] = Integer.parseInt(br.readLine());
        }
    }
}
