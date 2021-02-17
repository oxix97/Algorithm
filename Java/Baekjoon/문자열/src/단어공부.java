import java.util.*;
public class 단어공부 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next().toLowerCase();
        HashSet<String> hash = new HashSet<>();

        for(int i=0;i<str.length();i++)
            hash.add(str.substring(i, i+1));
        ArrayList<String> list = new ArrayList<>(hash);
        list.sort(null);
        int[] arr = new int[list.size()];
        for(int i=0;i<str.length();i++)
            arr[list.indexOf(str.substring(i,i+1))]++;
        int max = arr[0];
        int cont = 0;
        for(int i=0;i<arr.length;i++) {
            if(max<arr[i]) {
                max=arr[i];
                cont = i;
            }
        }
        for(int i=0; i<arr.length;i++) {
            if(cont != i && max==arr[i]) {
                System.out.println("?"); return;
            }
        }
        System.out.println(list.get(cont).toUpperCase());
    }
}
