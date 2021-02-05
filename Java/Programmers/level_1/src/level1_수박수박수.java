import java.util.*;
public class level1_수박수박수 {
    public static String solution(int n){
        int count = n/2;
        StringBuilder str = new StringBuilder();
        str.append("수박".repeat(Math.max(0, count)));
        if(count*2 + 1 == n) str.append("수");
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String result = solution(n);
        System.out.println(result);
    }
}
