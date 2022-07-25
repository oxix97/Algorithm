import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열_1874 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] > cnt) {
                for (int j = cnt + 1; j <= arr[i]; j++) {
                    s.push(j);
                    System.out.println(s.peek());
                    sb.append('+').append('\n');
                }
                cnt = arr[i];
            } else if (s.peek() != arr[i]) {
                System.out.println("NO");
                return;
            }
            System.out.println(s.pop());
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}
