import java.util.*;
public class level1_2016년 {
    public static String solution(int a,int b) {
        //1월1일이 금요일로 시작하기 때문에 편의상 금요일부터 순차적으로 입력한다.
        String[] date= {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        //1월부터 12월 까지 해당 하는 날짜이다.
        int[] Mdays = {31,29,31,30,31,30,31,31,30,31,30,31};
        int check = 0;

        // 배열은 0부터 시작하기 때문에 입력받은 월에서 -1 해준다.
        for(int i=0;i<a-1;i++)
            check += Mdays[i];

        //마찬가지로 -1 하여서 날짜를 입력받는다.
        check += b-1;

        //일주일을 반복하기 때문에 7로 나누어진 나머지가 해당 요일이다.

        return date[check%7];
    }
    public static void main(String[] args) {
        String result = solution(5,24);

        System.out.println(result);
    }
}
