import java.util.*;
public class 팩트리얼0의개수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int result = 0;
        int n = scan.nextInt();
        for(int i=5;i<=n;i*=5) result += n/i;
        System.out.println(result);
    }}
