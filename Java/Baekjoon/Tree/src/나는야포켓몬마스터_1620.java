import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터_1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static HashMap<Integer, String> map;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() throws IOException {
        for (int i = 1; i <= M; i++) {
            String input = br.readLine();
            try {
                int idx = Integer.parseInt(input);
                sb.append(map.get(idx)).append('\n');
            } catch (Exception e) {
                for (int key : map.keySet()) {
                    if (input.equals(map.get(key))) {
                        sb.append(key).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, br.readLine());
        }
    }
}
