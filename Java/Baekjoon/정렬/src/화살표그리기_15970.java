import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 화살표그리기_15970 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] lists;
    static StringTokenizer st;
    static int T, sum;

    public static void main(String[] args) throws IOException {
        init();
        calc();
        sb.append(sum);
        System.out.println(sb.toString());
    }

    private static void calc() {
        for (int j = 1; j <= T; j++) {
            for (int i = 0; i < lists[j].size(); i++) {
                if (i == 0) {
                    sum += lists[j].get(1) - lists[j].get(i);
                } else if (i == lists[j].size() - 1) {
                    sum += lists[j].get(i) - lists[j].get(i - 1);
                } else {
                    sum += Math.min(lists[j].get(i) - lists[j].get(i - 1), lists[j].get(i + 1) - lists[j].get(i));
                }
            }
        }

    }

    private static void init() throws IOException {
        T = Integer.parseInt(br.readLine());
        lists = new ArrayList[T + 1];
        for (int i = 1; i <= T; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            System.out.println("point : " + point + " , color : " + color);
            lists[color].add(point);
        }

        for (int i = 1; i <= T; i++) {
            Collections.sort(lists[i]);
        }
    }
}
