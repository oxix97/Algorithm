import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {
    static int N;
    static Work[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new Work[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr[i] = new Work(T, P);
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum = Math.max(sum, recursion(i + arr[i].T, arr[i].P));
        }
        System.out.println(sum);
    }

    private static int recursion(int n, int s) {
        if (n > N + 1) return 0;

        int sum = s;

        for (int i = n; i <= N; i++) {
            sum = Math.max(sum, recursion(i + arr[i].T, s + arr[i].P));
        }

        return sum;
    }

    static class Work {
        int T;
        int P;

        public Work(int T, int P) {
            this.T = T;
            this.P = P;
        }
    }

}
