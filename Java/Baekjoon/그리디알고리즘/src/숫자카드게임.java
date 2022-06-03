import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        br.readLine();

        int[] mins = new int[h];

        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            String[] temp = str.split(" ");
            int min = Integer.MAX_VALUE;
            for (String s : temp) {
                int item = Integer.parseInt(s);
                if (min > item) {
                    min = item;
                }
            }
            mins[i] = min;
            if(i!=h-1)
                br.readLine();
        }
        Arrays.sort(mins);
        System.out.println(mins[mins.length - 1]);
    }
}
