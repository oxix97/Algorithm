import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이진검색트리_5639 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> tree;
    static Node node;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        postOrder(node);
        System.out.println(sb);
    }

    private static void postOrder(Node n) {
        if (n == null) return;
        postOrder(n.left);
        postOrder(n.right);
        sb.append(n.n).append('\n');
    }

    private static void inputs() throws IOException {
        node = new Node(Integer.parseInt(br.readLine()));
        tree = new ArrayList<>();
        while (true) {
            String str = br.readLine();
            if (str == null || str.equals("")) break;
            node.insert(Integer.parseInt(str));
        }
    }

    static class Node {
        int n;
        Node left, right;

        Node(int n) {
            this.n = n;
        }

        Node(int n, Node left, Node right) {
            this.n = n;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.n) { // 루트 기준 오른쪽
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else { //루트 기준 왼쪽
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }
}
