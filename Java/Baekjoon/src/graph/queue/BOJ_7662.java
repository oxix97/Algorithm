package src.graph.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, K;
    static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        map = new TreeMap<>();

        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            for (int k = 1; k <= K; k++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    continue;
                }
                if (map.size() == 0) continue;
                int key = num == 1 ? map.lastKey() : map.firstKey();
                if (map.get(key) == 1) map.remove(key);
                else map.put(key, map.get(key) - 1);
            }
            if (map.size() == 0) sb.append("EMPTY").append('\n');
            else sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
            map.clear();
        }
        System.out.println(sb);
        br.close();
    }
}
