import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스택_10828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static ArrayDeque<Integer> list;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {

    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                list.add(Integer.parseInt(st.nextToken()));
            } else {
                int num = commandLine(cmd);
                sb.append(num).append('\n');
            }
        }
    }

    private static int commandLine(String cmd) {
        int num = 0;
        switch (cmd) {
            case "top":
                num = list.size() == 0 ? -1 : list.getLast();
                break;
            case "pop":
                num = list.size() == 0 ? -1 : list.removeLast();
                break;
            case "size":
                num = list.size();
                break;
            case "empty":
                num = list.size() == 0 ? 1 : 0;
                break;
            default:
                break;
        }
        return num;
    }
}
