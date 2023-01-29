


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
    static HashMap<Integer, String> numberMap;
    static HashMap<String, Integer> stringMap;

    public static void main(String[] args) throws IOException {
//        long start = System.currentTimeMillis();
        inputs();
        solution();
//        long end = System.currentTimeMillis();
//        System.out.println("time : " + (end - start) + "ms");
    }

    private static void solution() throws IOException {
        for (int i = 1; i <= M; i++) {
            String input = br.readLine();
            try {
                int idx = Integer.parseInt(input);
                sb.append(numberMap.get(idx)).append('\n');
            } catch (Exception e) {
                sb.append(stringMap.get(input)).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numberMap = new HashMap<>();
        stringMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            numberMap.put(i, input);
            stringMap.put(input, i);
        }
    }
}

