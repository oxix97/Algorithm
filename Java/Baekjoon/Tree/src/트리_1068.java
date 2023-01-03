import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리_1068 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, erase;
    static ArrayList<Integer>[] tree;
    static int[] leaf;
    static int ans = 0;
    static int root;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {

        for (int i = 0; i < N; i++) {
            if (tree[i].contains(erase)) {
                tree[i].remove(tree[i].indexOf(erase));
            }
        }
        if (root != erase)
            dfs(root);

        System.out.println(leaf[root]);
    }

    private static void dfs(int n) {
        if (tree[n].isEmpty()) {
            leaf[n] = 1;
        }
        for (int x : tree[n]) {
            dfs(x);
            leaf[n] += leaf[x];
        }
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        leaf = new int[N];

        for (int i = 0; i < N; i++)
            tree[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) {
                root = i;
                continue;
            }
            tree[n].add(i);
        }

        erase = Integer.parseInt(br.readLine());
    }
}
