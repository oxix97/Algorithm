import java.util.*;
import java.io.*;
public class 달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        if((v-a)%(a-b)==0)
            System.out.println((v-a)/(a-b)+1);
        else
            System.out.println((v-a)/(a-b)+2);
    }
}
