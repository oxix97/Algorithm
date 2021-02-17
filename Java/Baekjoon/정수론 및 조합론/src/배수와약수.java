import java.util.*;
public class 배수와약수 {
    public static String solution(int n, int m) {
        if(n<m && m%n==0) return "factor";
        else if(n>m && n%m==0) return "multiple";
        else return "neither";
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            if(n==0 && m==0) return;
            System.out.println(solution(n,m));
        }
    }
}
