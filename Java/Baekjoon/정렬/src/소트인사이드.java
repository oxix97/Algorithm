import java.util.*;
public class 소트인사이드 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        long n = scan.nextLong();
        String temp = Long.toString(n);
        for(int i=0;i<temp.length();i++)
            list.add(Integer.parseInt(temp.substring(i,i+1)));
        Collections.sort(list);
        for(int i=temp.length()-1;i>=0;i--)
            System.out.print(list.get(i));
    }
}
