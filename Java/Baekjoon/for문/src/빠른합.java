import java.util.*;
import java.io.*;
public class 빠른합 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<a;i++) {
            String[] temp = reader.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            int answer = x+y;
            sb.append(answer+"\n");
        }
        System.out.println(sb);
    }
}
