package props;
import java.util.*;
import java.math.*;
public class testify {
    public static void solution(int n) {
        if(n==0) return;
        solution(n-1);
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    public static void solution2(int n ) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solution(5);
        solution2(5);
    }
}
