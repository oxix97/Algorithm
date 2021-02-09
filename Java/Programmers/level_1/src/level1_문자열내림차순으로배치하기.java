import java.util.*;
import java.util.stream.*;
public class level1_문자열내림차순으로배치하기 {
    public static String soltuion(String s){
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new StringBuilder(new String(str)).reverse().toString();
    }
    public static void main(String[] args) {
        String s = "Zbcdefg";
        String result = soltuion(s);
        System.out.println(result);
    }
}
