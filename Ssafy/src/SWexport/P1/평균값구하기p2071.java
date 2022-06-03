package SWexport.P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균값구하기p2071 {
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 1; j <= 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
            }
            sb.append("#").append(i).append(" ").append(Math.round((double) sum / 10));
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
