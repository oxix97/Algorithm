import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.math.*;
public class Commit {
    public static String[] solution(String[] strings, int n){
        Arrays.sort(strings);
        if(n==0) return strings;


        for(int i=0;i<strings.length;i++){
            String str = "";
            str = strings[i].charAt(n) + strings[i].substring(0,n) + strings[i].substring(n+1);
            strings[i] = str;
        }

        return strings;
    }

    public static void main(String[] args) {
        String[] s1 = {"sun","bed","car"};
        String[] s2 = {"abce","abcd","cdx"};

        String[] result1 = solution(s1,1);
        String[] result2 = solution(s2,2);

        String str  = "abcdefg";
        String temp = "";
        int n = 2;

        for(String i : result1)
            System.out.println(i);

    }
}
