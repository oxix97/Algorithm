import java.util.*;
public class 알파벳찾기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int[] ans = new int[26];
        char[] arr = new char[26];
        for(int i=0;i<arr.length;i++) {
            arr[i] = (char)(i+97);
            ans[i] = -1;
        }
        for(int i=0;i<str.length();i++) {
            char temp = str.charAt(i);
            for(int j=0;j<arr.length;j++) {
                if(temp==arr[j] && ans[j] == -1) {
                    ans[j] = i;
                    break;
                }
            }
        }
        for(int i=0;i<ans.length;i++)
            System.out.println(ans[i]);
    }
}
