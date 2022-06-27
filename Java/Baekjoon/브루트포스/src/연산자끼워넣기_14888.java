import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {
    static int N;
    static int[] num;
    static int[] tools;

    static final int ADD = 0;
    static final int MINUS = 1;
    static final int MULTIPLE = 2;
    static final int DIVIDE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        tools = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            tools[i] = Integer.parseInt(st.nextToken());
        }

    }
}
