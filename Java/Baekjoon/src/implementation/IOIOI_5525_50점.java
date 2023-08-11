package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IOIOI_5525_50점 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static String S;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();
        int answer = 0;
        String IOI = "IO".repeat(N) + "I";

        for (int i = 0; i < M; i++) {
            if (S.startsWith(IOI, i)) ++answer;
        }

        System.out.println(answer);

        br.close();
    }
}
