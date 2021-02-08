import java.awt.List;
import java.util.*;
import java.io.*;
import java.lang.*;
public class level1_서울에서김서방찾기 {
    public static String solution(String[] seoul){
        return "김서방은 "+
                Arrays.asList(seoul).indexOf("Kim")
                +"에 있다.";
    }
    public static void main(String[] args) {
        String[] seoul = {"Jane","Kim"};
        String count = solution(seoul);
        System.out.println(count);
    }
}
