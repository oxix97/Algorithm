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



        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input : ");
        String input = scanner.nextLine();
        String answer = solution(input);

        System.out.println(answer);

    }
}
