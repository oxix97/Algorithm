import java.util.*;
public class 곱하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        String str = Integer.toString(b);
        for(int i=str.length()-1;i>=0;i--) {
            System.out.println(a*Integer.parseInt(str.substring(i, i+1)));
        }
        System.out.println(a*b);
    }
}
