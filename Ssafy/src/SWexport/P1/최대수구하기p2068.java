package SWexport.P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대수구하기p2068 {
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int max = 0;
            for (int j = 1; j <= 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
            }
            sb.append("#").append(i).append(' ').append(max);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
