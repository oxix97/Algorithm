import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_2164 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.offer(i);
        }

        while (list.size() != 1) {
            list.remove();
            int tmp = list.poll();
            list.add(tmp);
        }
        System.out.println(list.peek());
    }
}
