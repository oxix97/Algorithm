import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[1] == t2[1]) {
                    return t1[0] - t1[1];
                }
                return t1[1] - t2[1];
            }
        });

        int cnt = 0;
        int endstart = 0;

        for (int i = 0; i < N; i++) {
            //끝난 시각이 다음회의 시작 시간보다 작은 경우
            if (endstart <= arr[i][0]) {
                cnt++;
                endstart = arr[i][1];
            }
        }
        System.out.println(cnt);
    }

}
