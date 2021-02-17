import java.util.*;
public class 나머지 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0;i<10;i++) {
            int n = scan.nextInt();
            hash.add(n%42);
        }
        System.out.println(hash.size());
    }
}
