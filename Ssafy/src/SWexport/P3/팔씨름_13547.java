package SWexport.P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 팔씨름_13547 {
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            char[] arr = str.toCharArray();
            String answer = fight(arr);

            sb.append("#").append(i).append(' ').append(answer);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static String fight(char[] arr) {
        int cnt = 0;
        String ans = "YES";

        for (char c : arr) {
            if (c == 'x') {
                ++cnt;
            }
        }

        if (cnt >= 8) ans = "NO";

        return ans;
    }
}
