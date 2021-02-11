import java.util.*;
public class 숫자의합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String temp = scan.next();
        int sum = 0;
        for(int i=0;i<n;i++)
            sum += Integer.parseInt(temp.substring(i,i+1));
        System.out.println(sum);
    }
}
