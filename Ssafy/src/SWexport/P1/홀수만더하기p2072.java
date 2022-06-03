package SWexport.P1;

import java.io.*;
import java.util.StringTokenizer;

public class 홀수만더하기p2072 {
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 1; j <= 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 1) {
                    sum += num;
                }
            }
            sb.append("#").append(i).append(' ').append(sum);
            sb.append('\n');
        }
        br.close();
        System.out.println(sb.toString());
    }
}
