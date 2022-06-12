import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int cnt = 0;
    static int[] mArr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        mArr = new int[10001];
        Arrays.fill(mArr, 10001);
        mArr[0] = 0;
        br.readLine();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            if (i != n - 1) br.readLine();
        }

        for (int i : arr) {
            for (int j = i; j <= m; j++) {
                mArr[i] = 1;
                mArr[j] = Math.min(mArr[j], mArr[j - i] + 1);
            }
        }

        if (mArr[m] == 10001)
            System.out.println(-1);
        else
            System.out.println(mArr[m]);
    }
}
