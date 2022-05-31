import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _3의배수_1769 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String snum = br.readLine();
        list.add(3);
        list.add(6);
        list.add(9);
        recursion(snum, 0);
        System.out.println(sb.toString());
    }

    private static void recursion(String n, int cnt) {
        int sum = 0;

        if (n.length() == 1) {
            if (list.contains(Integer.parseInt(n))) {
                sb.append(cnt).append('\n').append("YES");
            } else {
                sb.append(cnt).append('\n').append("NO");
            }
        } else {
            for (int i = 0; i < n.length(); i++) {
                int num = Integer.parseInt(n.substring(i, i + 1));
                sum += num;
            }
            recursion(String.valueOf(sum), ++cnt);
        }
    }
}
