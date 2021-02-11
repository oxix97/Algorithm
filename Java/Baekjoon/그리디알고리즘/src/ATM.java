import java.util.*;
public class ATM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = scan.nextInt();
        int sum = 0;
        for(int i=0;i<n;i++) {
            int time = scan.nextInt();
            list.add(time);
        }
        Collections.sort(list);
        for(int i=0;i<n;i++) {
            if(i!=0)
                list.set(i, list.get(i-1)+list.get(i));
            sum+=list.get(i);
        }
        System.out.println(sum);
    }
}
