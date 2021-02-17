import java.util.*;
public class level1_최대공약수와최소공배수 {
    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int temp = Math.min(n, m);
        int count=0;
        for(int i=1; i<=temp;i++)
            if(n%i==0 && m%i==0)
                answer[0] = i;
        answer[1] = (n*m)/answer[0];
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        int[] arr = solution(n,m);

        for(int i : arr)
            System.out.println(i);
    }
}
