import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 케빈베이컨의6단계법칙_1389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, -1);
            answer[i] = bfs(i);
        }
        int result = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = N; i >= 1; i--) {
            if (result >= answer[i]) {
                result = answer[i];
                idx = i;
            }
        }
        System.out.println(idx);
    }

    private static int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 0;

        while (!q.isEmpty()) {
            n = q.poll();
            for (int i = 0; i < list[n].size(); i++) {
                int nn = list[n].get(i);
                if (visited[nn] != -1) continue;
                visited[nn] = visited[n] + 1;
                q.add(nn);
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += visited[i];
        }
        return answer;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new int[N + 1];
        answer = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }
}
