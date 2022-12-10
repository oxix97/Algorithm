import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 촌수계산_2644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N;
    static ArrayList<Integer>[] list;
    static int a, b;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        inputs();
        solution(a);
        System.out.println(dist[b]);
    }

    private static void solution(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        dist[n] = 0;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i : list[tmp]) {
                if (dist[i] != -1) continue;
                q.add(i);
                dist[i] = dist[tmp] + 1;
            }
        }
    }

    private static void inputs() throws IOException {
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[T + 1];
        dist = new int[T + 1];

        for (int i = 0; i <= T; i++) {
            list[i] = new ArrayList<>();
            dist[i] = -1;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list[y].add(x);
            list[x].add(y);
        }
    }
}
