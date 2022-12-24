import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무탈출_15900 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> leaf;
    static int[] ans;
    static int N;
    static int answer = 0;

    //성원이가 선 공격
    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        dfs(1, -1, 0);
        System.out.println(output());
    }

    private static String output() {
        return answer % 2 == 1 ? "Yes" : "No";
    }

    private static void dfs(int n, int par, int cnt) {
        for (int item : list[n]) {
            if (item == par) continue;
            ans[item] = n;
            dfs(item, n, cnt + 1);
        }

        if (list[n].size() == 1)
            answer += cnt;
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        ans = new int[N + 1];
        leaf = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }
}
