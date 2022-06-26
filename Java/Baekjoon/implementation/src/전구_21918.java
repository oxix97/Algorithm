import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전구_21918 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[4001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            func(command, b, c);
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void func(int command, int b, int c) {
        if (command == 1) {
            arr[b] = c;
        } else if (command == 2) {
            for (int i = b; i <= c; i++) {
                if (arr[i] == 1) {
                    arr[i] = 0;
                } else {
                    arr[i] = 1;
                }
            }
        } else if (command == 3) {
            for (int i = b; i <= c; i++) {
                arr[i] = 0;
            }
        } else if (command == 4) {
            for (int i = b; i <= c; i++) {
                arr[i] = 1;
            }
        } else {
            System.out.println("error");
        }
    }
}
