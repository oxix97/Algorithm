import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<Prob> list = new LinkedList<>();
            Integer[] arr = new Integer[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if (j == m) {
                    list.add(new Prob(arr[j], true));
                } else {
                    list.add(new Prob(arr[j], false));
                }
            }

            Arrays.sort(arr, Collections.reverseOrder());
            int cnt = 0;


            for (int num : arr) {
                while (true) {
                    Prob tmp = list.removeFirst();
                    if (num == tmp.idx) {
                        ++cnt;
                        if (tmp.value) {
                            sb.append(cnt).append('\n');
                        }
                        break;
                    } else {
                        list.offerLast(tmp);
                    }
                }
            }

        }
        System.out.println(sb);
    }

    static class Prob {
        int idx;
        boolean value;

        public Prob(int idx, boolean value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
