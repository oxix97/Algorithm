import java.util.Arrays;

public class level1_나누어떨어지는숫자배열_Clear {
    public static int[] solution(int[] arr, int divisor){
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};
        Arrays.sort(answer);
        return answer;

    }
    public static void main(String[] args) {

    }
}
