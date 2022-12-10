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
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        int[][] tmp = {{a, b}, {b, a}};
        int answer = 0;
        for (int i = 0; i < 1; i++) {
            Arrays.fill(visited, false);
            answer = solution(tmp[i][0], tmp[i][1]);
        }
        System.out.println(answer);
    }

    private static int solution(int v, int target) {
        int num = v;
        int answer = 0;
        visited[num] = true;
        while (true) {
            boolean find = false;
            for (int i = 1; i <= N; i++) {
                if (list[i].contains(num)) {
                    num = i;
                    answer++;
                    visited[num] = true;
                    find = true;
                    break;
                }
            }
            if (find && num == target) {
                return answer;
            } else if (find && list[num].contains(target)) {
                return answer + 1;
            } else if (!find) break;
        }
        return -1;
    }

    private static void inputs() throws IOException {
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[T + 1];
        visited = new boolean[T + 1];

        for (int i = 0; i <= T; i++) {
            list[i] = new ArrayList<>();
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
