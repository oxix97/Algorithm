import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DefaultInput {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        System.out.println(sb.toString());
    }

    private static void inputs() throws IOException {

    }
}
