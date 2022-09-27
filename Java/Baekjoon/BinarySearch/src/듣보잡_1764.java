import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 듣보잡_1764 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, ans;
    static ArrayList<String> nArr, ansArr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nArr = new ArrayList<>();
        ansArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nArr.add(br.readLine());
        }
        Collections.sort(nArr);
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (binarySearch(str)) {
                ansArr.add(str);
            }
        }
        Collections.sort(ansArr);
        sb.append(ansArr.size()).append('\n');
        for (String str : ansArr) {
            sb.append(str).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static boolean binarySearch(String str) {
        int L = 0, R = M - 1;
        int mid;
        while (L <= R) {
            mid = (L + R) / 2;
            if (nArr.get(mid).equals(str)) {
                return true;
            }
            if (nArr.get(mid).compareTo(str) < 0) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }
}
