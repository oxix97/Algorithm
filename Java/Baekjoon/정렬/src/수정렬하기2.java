import java.util.*;
import java.io.*;
public class 수정렬하기2 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
            list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        for(int i=0;i<n;i++)
            bw.write(list.get(i)+"\n");
        bw.close();
        br.close();
    }
}
