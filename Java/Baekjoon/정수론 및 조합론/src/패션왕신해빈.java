import java.util.*;
public class 패션왕신해빈 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String,Integer> hash = new HashMap<>();
        int n = scan.nextInt();
        for(int i=1;i<=n;i++) {
            int m = scan.nextInt();
            for(int j=1;j<=m;j++) {
                String wear = scan.next();
                String point = scan.next();
                if(hash.containsKey(point))
                    hash.put(point, hash.get(point)+1);
                else
                    hash.put(point, 1);
            }
            int answer = 1;
            for(int j : hash.values())
                answer *= j+1;
            System.out.println(answer-1);
            hash.clear();
        }
    }
}
