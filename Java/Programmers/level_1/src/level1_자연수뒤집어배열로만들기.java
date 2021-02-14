import java.util.*;
public class level1_자연수뒤집어배열로만들기 {
    public static int[] solution(long n) {
        StringBuilder sb = new StringBuilder(Long.toString(n)).reverse();
        int[] answer = sb.chars().toArray();
        for(int i=0;i<answer.length;i++)
            answer[i] -= 48;
        return answer;
    }

    public static void main(String[] args) {
        long n = 12345;
        int[] a = solution(n);
        for (int i : a)
            System.out.print(i + " ");
    }
}
