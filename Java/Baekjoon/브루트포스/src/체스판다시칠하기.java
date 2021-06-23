import java.io.*;
import java.util.*;
public class 체스판다시칠하기 {
    static int min = 64;
    static String[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine()," ");

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        field = new String[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                field[i][j] = reader.readLine();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                field[i][j] = reader.readLine();
            }
        }

        int N_row = N-7;
        int M_row = M-7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_row; j++) {
                check(i,j);
            }
        }
        System.out.println(min);
    }

    public static void check(int BeginX, int BeginY) {
        int endX = BeginX + 8;
        int endY = BeginY + 8;
        int count = 0;

        String color = field[BeginX][BeginY];

        for (int i = 0; i < endX; i++) {
            for (int j = 0; j < endY; j++) {
                if(!color.equals(field[i][j])) ++count;
            }
            count = Math.min(count,64-count);
            min = Math.min(min,count);
        }
    }
}
