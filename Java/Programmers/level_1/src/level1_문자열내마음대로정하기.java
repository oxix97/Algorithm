import java.util.*;
import java.io.*;
import java.math.*;
public class level1_문자열내마음대로정하기 {

    public static String[] solution(String[] strings, int n){
        if(n==0) {
            Arrays.sort(strings);
            return strings;
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            list.add(strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(list);

        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i] = list.get(i).substring(1);
        return answer;
    }

    public static void printInfo(String[] strings, int n){
        String[] result = solution(strings,n);

        for(String str : result)
            System.out.print(str + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        String[] s1 = {"sun", "bed", "car"};
        String[] s2 = {"abce", "abcd", "cdx"};
        printInfo(s1,1);
        printInfo(s2,2);
    }
}
