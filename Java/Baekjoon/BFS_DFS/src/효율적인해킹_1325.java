import java.util.*;

public class 효율적인해킹_1325 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;
    static int[] visited;
    static ArrayList<Node> list = new ArrayList<>();
    static int cnt;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        input();
        output();
    }

    static class Node {
        int start = 0;
        int end = 0;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    private static void dfs(Node node, int idx, int count) {
        visited[idx + 1] = count;

        for (int i = 0; i < list.size(); i++) {
            if (idx == i) continue;
            if (node.end == list.get(i).start) {
                ++count;
                dfs(list.get(i), idx, count);
            }
        }
    }

    private static void output() {
        for (int i = 0; i < list.size(); i++) {
            dfs(list.get(i), i, visited[i + 1]);
        }
        int[] temp = Arrays.copyOf(visited, visited.length);
        Arrays.sort(temp);
        int max = temp[temp.length - 1];
        for (int i = 0; i < visited.length; i++) {
            if (max == visited[i])
                System.out.print(i + " ");
        }
    }

    private static void input() {
        for (int i = 1; i < M + 1; i++) {
            int end = sc.nextInt();
            int start = sc.nextInt();
            list.add(new Node(start, end));
        }
        visited = new int[M + 1];
        cnt = 1;
        Arrays.fill(visited, 1);
    }
}
