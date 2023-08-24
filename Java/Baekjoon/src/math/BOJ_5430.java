package src.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static char[] command;
    static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            command = br.readLine().toCharArray();
            N = Integer.parseInt(br.readLine());
            String line = br.readLine();
            q = new LinkedList<>();
            for (String s : line.substring(1, line.length() - 1).split(",")) {
                if (!s.equals(""))
                    q.add(Integer.parseInt(s));
            }

            boolean piv = true;
            boolean isOk = true;

            for (char c : command) {
                if (c == 'D') {
                    if (q.isEmpty()) {
                        isOk = false;
                        break;
                    }
                    if (piv) q.pollFirst();
                    else q.pollLast();
                } else
                    piv = !piv;
            }
            if (!isOk) {
                sb.append("error").append('\n');
                continue;
            }
            sb.append('[');
            while (!q.isEmpty()) {
                sb.append(piv ? q.pollFirst() : q.pollLast());
                if (q.size() != 0)
                    sb.append(',');
            }
            sb.append(']').append('\n');
        }
        System.out.println(sb.toString());
    }
}
