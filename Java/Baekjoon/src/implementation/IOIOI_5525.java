package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IOIOI_5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static char[] S;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine().toCharArray();
        int cnt = 0;
        int answer = 0;
        for (int i = 1; i < M - 1; i++) {
            if (S[i - 1] == 'I' && S[i] == 'O' && S[i + 1] == 'I') {
                ++cnt;
                if (cnt == N) {
                    ++answer;
                    cnt--;
                }
                i++;
            } else {
                cnt = 0;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
