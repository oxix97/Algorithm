import java.util.*;
public class level2_124나라의숫자 {
    public static String solution(int n) {
        Stack<String> s = new Stack<>();
        String answer = "";
        int temp = n;
        while(temp > 0) {
            int num = temp%3;
            temp /=3;
            switch(num) {
                case 0:
                    s.push("4");
                    temp -= 1;
                    break;
                case 1:
                    s.push("1"); break;
                case 2:
                    s.push("2"); break;
            }
        }
        int size = s.size();
        for(int i=0;i<size;i++)
            answer += s.pop();
        return answer;
    }

    public static void main(String[] args) {
        int[] ex = {1,2,3,4};
        for(int i=0;i<ex.length;i++){
            String result = solution(ex[i]);
            System.out.println(result);
        }
    }
}
