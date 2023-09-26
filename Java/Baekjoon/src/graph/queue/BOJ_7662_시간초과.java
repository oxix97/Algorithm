package src.graph.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7662_시간초과 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, K;
    static Queue<Integer> minQ = new PriorityQueue<>();
    static Queue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            for (int k = 1; k <= K; k++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                int tmp;
                if (cmd.equals("I")) {
                    maxQ.add(num);
                    minQ.add(num);
                    continue;
                }
                if (isNull()) continue;
                if (num == -1) {
                    tmp = minQ.poll();
                    maxQ.remove(tmp);
                } else if (num == 1) {
                    tmp = maxQ.poll();
                    minQ.remove(tmp);
                }
            }
            if (isNull()) sb.append("EMPTY").append('\n');
            else sb.append(maxQ.poll()).append(' ').append(minQ.poll());
            minQ.clear();
            maxQ.clear();
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isNull() {
        return minQ.isEmpty() || maxQ.isEmpty();
    }
}
