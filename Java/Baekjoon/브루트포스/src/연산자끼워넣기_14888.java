import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연산자끼워넣기_14888 {
    static int N, max, min;
    static int[] num, tools, order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        tools = new int[5];
        order = new int[N + 1];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            tools[i] = Integer.parseInt(st.nextToken());
        }

        recursion(1);
        System.out.println(max);
        System.out.println(min);

    }

    static int calc() {
        int value = num[1];

        for (int i = 1; i <= N - 1; i++) {
            if (order[i] == 1)
                value = value + num[i + 1];
            if (order[i] == 2)
                value = value - num[i + 1];
            if (order[i] == 3)
                value = value * num[i + 1];
            if (order[i] == 4)
                value = value / num[i + 1];
        }
        return value;
    }

    private static void recursion(int k) {
        if (k == N) {
            int value = calc();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (tools[i] >= 1) {
                    --tools[i];
                    order[k] = i;
                    recursion(k + 1);
                    tools[i]++;
                    order[k] = 0;
                }
            }
        }
    }

}
