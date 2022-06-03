package SWexport.P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큰놈작은놈같은놈 {
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("#").append(i).append(' ');

            if (a == b) sb.append("=");
            else if (a > b) sb.append(">");
            else sb.append("<");

            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
