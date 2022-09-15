import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수열정렬_1015 {
    static int N;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Number[] numbers;

    static class Number implements Comparable<Number> {
        int index;
        int value;

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Number number) {
            return this.value - number.value;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        recursion();
        System.out.println(sb.toString());
    }

    static void recursion() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (numbers[j].index == i && numbers[j].value == arr[i]) {
                    sb.append(j).append(' ');
                }
            }
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        numbers = new Number[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            numbers[i] = new Number(i, arr[i]);
        }
        Arrays.sort(numbers);
    }
}
