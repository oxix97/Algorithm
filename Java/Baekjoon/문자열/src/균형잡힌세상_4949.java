import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for (int i = 0; i < s.length(); i++) {
                if (!check) {
                    break;
                }
                try {
                    switch (s.charAt(i)) {
                        case '(':
                            stack.push(')');
                            break;
                        case '[':
                            stack.push(']');
                            break;
                        case ']':
                            check = stack.pop() == ']';
                            break;
                        case ')':
                            check = stack.pop() == ')';
                            break;
                    }
                } catch (Exception e) {
                    check = false;
                }
            }
            if (check && stack.isEmpty())
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');
        }
        System.out.println(sb);
    }
}
