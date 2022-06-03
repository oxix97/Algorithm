import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의나이트 {
    static char[] w = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    static int[] h = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();

        int cnt = 0;
        int index1 = 0;
        int index2 = 0;

        int[] arr1 = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] arr2 = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < w.length; i++) {
            if (inputs[0] == w[i]) index1 = i;
        }
        for (int i = 0; i < h.length; i++) {
            System.out.println("input[1] : " + inputs[1]);
            System.out.println("h[i] : " + h[i]);
            if (Integer.parseInt(String.valueOf(inputs[1])) == h[i]) {
                index2 = i;
                break;
            }
        }

        for (int i = 0; i < 8; i++) {
            int width = index1 + arr1[i];
            int height = index2 + arr2[i];
            System.out.println(index1 + " " + arr1[i] + " = " + width);
            System.out.println(index2 + " " + arr2[i] + " = " + height);

            if (width >= 0 && width < 8) {
                if (height >= 0 && height < 8)
                    ++cnt;
            }
        }
        System.out.println(cnt);
    }
}
