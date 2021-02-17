import java.util.*;
public class level1_문자열을정수로바꾸기 {
    public static int solution1(String s) {
        return Integer.parseInt(s);
    }
    public static int solution2(String s){
        boolean count = true;
        int result = 0;
        int i = 0;
        if(s.charAt(0) == '+') i=1;
        else if(s.charAt(0) == '-') { i=1; count = false; }

        for(;i<s.length();i++)
            result = result * 10 + (s.charAt(i) - '0');

        return count ? result : -1 * result;
    }
    public static void main(String[] args) {
        String str = "-1234";
        int sol = solution2(str);
        System.out.println(sol);

    }
}
