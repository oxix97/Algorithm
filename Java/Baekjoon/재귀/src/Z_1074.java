import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, R, C;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        check(0, 0, (int) Math.pow(2, N));
    }

    private static void check(int r, int c, int size) {
        if (size == 1) {
            sb.append(cnt);
            return;
        }
        int newSize = size / 2;

        if (R < r + newSize && C < c + newSize) { //1
            System.out.println(1+" , cnt : "+cnt);
            check(r, c, newSize);
        } else if (R < r + newSize && C >= c + newSize) { //2
            cnt += (size * size) / 4;
            System.out.println(2+" , cnt : "+cnt);
            check(r, c + newSize, newSize);
        } else if (R >= r + newSize && C < c + newSize) {//3
            cnt += ((size * size) / 4) * 2;
            System.out.println(3+" , cnt : "+cnt);
            check(r + newSize, c, newSize);
        } else {//4
            cnt += ((size * size) / 4) * 3;
            System.out.println(4+" , cnt : "+cnt);
            check(r + newSize, c + newSize, newSize);
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }
}
