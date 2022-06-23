import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        int sum = Integer.MAX_VALUE;

        for (String item : input) {
            int tmp = 0;
            String[] s = item.split("\\+");
            for (String value : s) {
                tmp += Integer.parseInt(value);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }

        System.out.println(sum);
    }
}

