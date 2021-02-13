import java.util.*;
public class level1_문자열을정수로바꾸기 {
    public static int solution1(String s) {
        return Integer.parseInt(s);
    }
    public static int solution2(String s){
        boolean sign = true;
        int num = 0;

        for(int i=1;i<s.length();i++)
            num = num * 10 + (s.charAt(i) - '0');

        if(s.charAt(0) == '-') sign = false;

        return sign ? num : -1 *num;
    }
    public static void main(String[] args) {
        String str = "+1234";
        int sol = solution2(str);
        System.out.println(sol);

    }
}
