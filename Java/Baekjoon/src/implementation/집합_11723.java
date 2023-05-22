package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 집합_11723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {

    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> all = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            all.add(i);
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("all")) {
                list = new ArrayList<>(all);
            } else if (cmd.equals("empty")) {
                list.clear();
            } else {
                int num = Integer.parseInt(st.nextToken());
                boolean check = list.contains(num);
                switch (cmd) {
                    case "add": {
                        list.add(num);
                        break;
                    }
                    case "check": {
                        sb.append(check ? 1 : 0).append('\n');
                        break;
                    }
                    case "remove": {
                        if (check) {
                            int idx = list.indexOf(num);
                            list.remove(idx);
                        }
                        break;
                    }
                    case "toggle": {
                        if (check) {
                            int idx = list.indexOf(num);
                            list.remove(idx);
                        } else {
                            list.add(num);
                        }
                        break;
                    }

                }
            }
        }
    }
}
