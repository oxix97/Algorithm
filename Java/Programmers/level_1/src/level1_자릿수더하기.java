import java.util.*;
public class level1_자릿수더하기 {
    public static int solution(int n) {
        int answer = 0;
        int temp = Integer.toString(n).length();
        if(temp==1)
            return n;
        for(int i=(int)Math.pow(10, temp-1);i>0;i=i/10) {
            answer += n/i;
            n -= (n/i)*i;
        }
        return answer;
    }
    public static int solution1(int n){
        int[] s = Integer.toString(n).chars().toArray();
        for(int i=0;i<s.length;i++) s[i] -= 48;
        return Arrays.stream(s).sum();
    }
    public static void main(String[] args) {
        int n = 987;
        System.out.println(solution(n));
        System.out.println(solution1(n));
    }
}
