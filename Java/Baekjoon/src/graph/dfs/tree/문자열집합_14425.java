package src.graph.dfs.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열집합_14425 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        //N개 문자열, M개
        //M번 문자열 S에 포함된거 개수 새기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //S 집합 생성
        Node root = new Node();

        //N번 집합 S에 포함 문자열 포함 시키기
        while (N > 0) {
            char[] chars = br.readLine().toCharArray();
            Node now = root;
            for (char c : chars) {
                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new Node();
                }
                now = now.next[c - 'a'];
            }
            now.isEnd = true;
            N--;
        }

        int cnt = 0;

        while (M > 0) {
            char[] chars = br.readLine().toCharArray();
            Node now = root;
            int length = 0;

            for (char c : chars) {
                if (now.next[c - 'a'] == null) {
                    break;
                }
                ++length;
                now = now.next[c - 'a'];
            }

            if (now.isEnd && length == chars.length) ++cnt;
            --M;
        }

        System.out.println(cnt);
        br.close();
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
}
