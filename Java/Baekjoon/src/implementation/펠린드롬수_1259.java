package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 펠린드롬수_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            char[] arr = br.readLine().toCharArray();
            int cnt = 0;
            if (arr[0] == '0' && arr.length == 1) {
                break;
            }

            for (int j = 0; j < arr.length / 2; j++) {
                if (arr[j] != arr[arr.length - 1 - j]) {
                    cnt = 1;
                    break;
                }
            }

            if (cnt == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

//        br.readLine();
    }
}
