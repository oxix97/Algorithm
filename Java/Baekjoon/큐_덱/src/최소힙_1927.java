import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소힙_1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {

    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                printInfo();
            } else {
                queue.add(n);
            }
        }
    }

    private static void printInfo() {
        if (queue.isEmpty()) {
            sb.append(0).append('\n');
        } else {
            sb.append(queue.poll()).append('\n');
        }
    }
}
