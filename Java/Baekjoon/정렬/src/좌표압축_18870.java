import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축_18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer> list;
    static ArrayList<Integer> sortedList;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        for (int i = 0; i < N; i++) {
            int num = list.get(i);
            sb.append(sortedList.indexOf(num)).append(' ');
        }
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            set.add(num);
        }
        sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

    }
}
