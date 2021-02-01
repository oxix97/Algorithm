import java.util.*;
public class level1_문자열다루기기본_예외처리 {
    public static boolean solution(String s){
        try {
            Integer.parseInt(s);
        }catch(NumberFormatException e ){
            return false;
        }finally{
            if(s.length() != 4 && s.length() != 6)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "a234";
        String s2 = "1234";

        boolean ans1 = solution(s1);
        boolean ans2 = solution(s2);

        System.out.println(ans1);
        System.out.println(ans2);

    }
}
