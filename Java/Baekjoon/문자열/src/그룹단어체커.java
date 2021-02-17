import java.util.*;
public class 그룹단어체커 {
    public static boolean solution(String str) {
        ArrayList<String> list = new ArrayList<>();
        String[] arr = new String[str.length()];
        for(int i=0;i<arr.length;i++)
            arr[i] = str.substring(i,i+1);
        for(int i=0;i<arr.length-1;i++)
            if(!arr[i].equals(arr[i+1]))
                list.add(arr[i]);
        list.add(arr[arr.length-1]);
        int size = list.size();
        HashSet<String> hash = new HashSet<>(list);
        if(size==hash.size())
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int answer = 0;
        for(int i=0; i<n;i++) {
            String str = scan.next();
            if(solution(str))
                answer++;
        }
        System.out.println(answer);
    }
}
