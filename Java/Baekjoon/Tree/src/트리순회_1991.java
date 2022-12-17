import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리순회_1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    //-19 -> '.'
    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        System.out.println(sb.toString());
    }

    private static void postOrder(int n) {
        if (n < 0) return;
        postOrder(tree[n].get(0));
        postOrder(tree[n].get(1));
        sb.append((char) (n + 'A'));
    }

    private static void inOrder(int n) {
        if (n < 0) return;
        inOrder(tree[n].get(0));
        sb.append((char) (n + 'A'));
        inOrder(tree[n].get(1));
    }

    private static void preOrder(int n) {
        if (n < 0) return;
        sb.append((char) (n + 'A'));
        preOrder(tree[n].get(0));
        preOrder(tree[n].get(1));
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = st.nextToken().charAt(0) - 'A';
            int[] children = {
                    st.nextToken().charAt(0) - 'A',
                    st.nextToken().charAt(0) - 'A'
            };

            tree[n].add(children[0]);
            tree[n].add(children[1]);
        }
    }
}
