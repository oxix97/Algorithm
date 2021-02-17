import java.util.*;
public class 동전0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<>();
        int n = scan.nextInt();
        int k = scan.nextInt();
        int coin = 0;
        for(int i=0;i<n;i++) {
            long money = scan.nextLong();
            list.add(money);
        }
        Collections.sort(list);
        for(int i=n-1;i>=0;i--) {
            while(list.get(i) <= k) {
                k-=list.get(i);
                coin++;
            }
        }
        System.out.println(coin);
    }
}