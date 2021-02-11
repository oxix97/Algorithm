import java.util.*;
public class 요세푸스문제0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = scan.nextInt();
        int k = scan.nextInt()-1;
        int cont = k;
        for(int i=1;i<=n;i++) list.add(i);
        System.out.print("<");
        while(list.size() != 1) {
            System.out.print(list.remove(cont)+", ");
            cont = (cont+k)%list.size();
        }
        System.out.print(list.remove(0)+">");
    }
}
