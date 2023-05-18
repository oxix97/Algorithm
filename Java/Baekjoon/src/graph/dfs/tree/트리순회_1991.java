package src.graph.dfs.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회_1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        N = Integer.parseInt(br.readLine());
        arr = new int[26][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int node = input[0].charAt(0) - 'A';
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            if (left == '.') arr[node][0] = -1;
            else arr[node][0] = left - 'A';

            if (right == '.') arr[node][1] = -1;
            else arr[node][1] = right - 'A';
        }

        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);

        System.out.println(sb);
    }

    private static void preOrder(int n) {
        if (n == -1) return;
        append(n);
        preOrder(arr[n][0]);
        preOrder(arr[n][1]);
    }

    private static void inOrder(int n) {
        if (n == -1) return;
        inOrder(arr[n][0]);
        append(n);
        inOrder(arr[n][1]);
    }

    private static void postOrder(int n) {
        if (n == -1) return;
        postOrder(arr[n][0]);
        postOrder(arr[n][1]);
        append(n);
    }

    private static void append(int n) {
        sb.append((char) (n + 'A'));
    }
}
