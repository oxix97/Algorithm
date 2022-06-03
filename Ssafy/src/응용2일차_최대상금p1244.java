import java.util.Scanner;

public class 응용2일차_최대상금p1244 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int n = sc.nextInt();
            int cnt = sc.nextInt();
            String sn = String.valueOf(n);
            int max = 0;

            for (int j = 0; j < cnt; j++) {
                int temp = Integer.parseInt(sn.substring(j, j + 1));
                for (int k = 1; k < sn.length(); k++) {
                    int num = Integer.parseInt(sn.substring(k, k + 1));

                }
            }

        }
    }
}
