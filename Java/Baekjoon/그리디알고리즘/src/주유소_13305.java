import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {
    static int N;
    static long[] road;
    static long[] station;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        road = new long[N - 1];
        station = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < road.length; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < station.length; i++) {
            station[i] = Integer.parseInt(st.nextToken());
            if (i >= 1) {
                station[i] = Math.min(station[i - 1], station[i]);
            }
        }

        long sum = 0;

        for (int i = 0; i < road.length; i++) {
            sum += (road[i] * station[i]);
        }

        System.out.println(sum);
    }
}
