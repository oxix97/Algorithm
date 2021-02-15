import java.util.*;
public class level1_정수내림차순으로배열하기 {
    public static long solution(long n) {
        char[] answer = Long.toString(n).toCharArray();
        Arrays.sort(answer);
        StringBuilder sb = new StringBuilder(new String(answer)).reverse();
        return Long.parseLong(String.valueOf(sb));
    }

    public static void main(String[] args) {
        long n = 1234569874;
        System.out.println(solution(n));
    }
}
