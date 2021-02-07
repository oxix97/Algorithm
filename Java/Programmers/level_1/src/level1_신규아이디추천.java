import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.lang.*;
public class level1_신규아이디추천 {
    public static String solution(String new_id){
        new_id = new_id.toLowerCase(); //1단계
        String answer = "";

        for(int i=0;i<new_id.length();i++){ //2단계
            String str = new_id.substring(i,i+1);
            try{
                Integer.parseInt(str);
                answer += str;

            }catch(NumberFormatException e){
                if((int)str.charAt(0) >=97 && (int)str.charAt(0)<=122) answer += str;
                if(str.equals("-") || str.equals("_") || str.equals(".")) answer += str;
            }
        }
        try{
            while(answer.charAt(0) == '.') answer = answer.substring(1,answer.length()-1); //4단계
            while(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0,answer.length()-2);
        }catch(StringIndexOutOfBoundsException e){
            answer  = "a".repeat(new_id.length()); //5단
        }

        String str = ""; //3단계
        for(int i=0;i<answer.length();i++){
            if(answer.charAt(i) == '.' && answer.charAt(i) == answer.charAt(i+1))
                continue;
            str += answer.charAt(i);
        }
        answer = str;

        if(answer.length()>=16) answer = answer.substring(0,15);

        while(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0,answer.length()-1); //6단계

        while(answer.length()<=2) answer += answer.charAt(answer.length()-1); //7단계

        return answer;
    }
    public static void main(String[] args) {
        String str1 = "...!@BaT#*..y.abcdefghijklm";
        String str2 = "z-+.^.";
        String str3 = "=.=";
        String str4 = "123_.def";
        String str5 = "abcdefghijklmn.p";
        String cus = "...";

        String result1 = solution(str1);
        String result2 = solution(str2);
        String result3 = solution(str3);
        String result4 = solution(str4);
        String result5 = solution(str5);
        String recus = solution(cus);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(recus);


    }
}
