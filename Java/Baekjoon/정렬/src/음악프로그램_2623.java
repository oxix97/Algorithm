import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 음악프로그램_2623 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> result;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() throws IOException {
        addSingers();
        sortSingers();
        checkResult();
    }

    private static void checkResult() {
        if (result.size() == N) {
            for (int i : result)
                sb.append(i).append('\n');
        } else
            sb.append(0);
        System.out.println(sb);
    }

    private static void sortSingers() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int num = q.poll();
            result.add(num);

            for (int n : list[num]) {
                indegree[n]--;

                if (indegree[n] == 0)
                    q.offer(n);
            }
        }
    }

    private static void addSingers() throws IOException {
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());

            for (int j = 1; j < cnt; j++) {
                int singer = Integer.parseInt(st.nextToken());
                list[before].add(singer);
                ++indegree[singer];
                before = singer;
            }
        }

    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        result = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
    }
}
