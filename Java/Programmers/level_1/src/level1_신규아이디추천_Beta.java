import java.lang.*;

public class level1_신규아이디추천_Beta {
    public static String solution(String new_id){
        // step 1
        String answer = new_id.toLowerCase();
        String temp = "";

        // step 2
        for(int i=0;i<answer.length();i++){
            String str = answer.substring(i,i+1);
            try{
                Integer.parseInt(str);
                temp += str;
            }catch(NumberFormatException e){
                if((int)str.charAt(0) >=97 && (int)str.charAt(0)<=122) temp += str;
                if(str.equals("-") || str.equals("_") || str.equals(".")) temp += str;
            }
        }
        answer = temp;
        temp = "";

        //step 3
        for(int i=0;i<answer.length()-1;i++){
            char str = answer.charAt(i);
            if(str == '.' && str == answer.charAt(i+1)) continue;
            temp += str;
        }

        if(answer.length() == 0) answer = "a";

        if('.' != answer.charAt(answer.length()-1))
            temp += answer.charAt(answer.length()-1);
        answer = temp;

        //step 3.5
        if(answer.length() == 0) answer = "a";

        //step 4
        while(answer.charAt(0) == '.') answer = answer.substring(1);
        while(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0,answer.length()-1);

        //step 5
        if(answer.length() == 0) answer = "a";

        //step 6
        if(answer.length()>=16) answer = answer.substring(0,15);
        while(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0,answer.length()-1);

        //step 7
        while(answer.length()<=2) answer += answer.charAt(answer.length()-1);

        return answer;
    }
    public static void main(String[] args) {

        String str1 = "...!@BaT#*..y.abcdefghijklm";
        String str2 = "z-+.^.";
        String str3 = "=.=";
        String str4 = "123_.def";
        String str5 = "abcdefghijklmn.p";


        String result1 = solution(str1);
        String result2 = solution(str2);
        String result3 = solution(str3);
        String result4 = solution(str4);
        String result5 = solution(str5);


        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

        String cus = "~!@#$%^&*()=+[{]}:?,<>/";
        String recus = solution(cus);
        System.out.println(recus);



    }
}
