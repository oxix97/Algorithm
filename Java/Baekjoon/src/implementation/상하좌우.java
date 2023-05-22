package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상하좌우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.readLine();
        String s = br.readLine();
        String[] commands = s.split(" ");

        int w = 1;
        int h = 1;

        for (String c : commands) {
            switch (c) {
                case "L": {
                    if (w != 1) --w;
                    break;
                }
                case "R": {
                    if (w != N) ++w;
                    break;
                }
                case "U": {
                    if (h != 1) --h;
                    break;
                }
                case "D": {
                    if (h != N) ++h;
                    break;
                }
            }
        }
        System.out.println(h + " " + w);
    }
}
