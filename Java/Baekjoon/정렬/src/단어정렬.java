import java.util.*;
public class 단어정렬 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashSet<String> set = new HashSet<>();
        for(int i=1;i<=n;i++) {
            String str = scan.next();
            set.add(str);
        }
        ArrayList<String> list = new ArrayList(set);
        Collections.sort(list);
        int[] arr = new int[list.size()];
        int cont = 0;
        for(int i=0;i<list.size();i++)
            arr[i] = list.get(i).length();
        Arrays.sort(arr);
        while(list.size()!=0) {
            for(int i=0;i<list.size();i++) {
                if(list.get(i).length()==arr[cont]) {
                    System.out.println(list.remove(i));
                    cont++;
                    break;
                }
            }
        }
    }
}
