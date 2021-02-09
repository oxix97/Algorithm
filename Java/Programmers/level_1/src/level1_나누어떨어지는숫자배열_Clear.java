import java.util.Arrays;

public class level1_나누어떨어지는숫자배열_Clear {
    public static int[] solution(int[] arr, int divisor){
        int[] answer = Arrays.stream(arr).
                filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};
        else Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] arr1 = {5,9,7,10};
        int[] arr2 = {2,36,1,3};
        int[] arr3 = {3,2,6};

        int[] re1 = solution(arr1,5);
        int[] re2 = solution(arr2,1);
        int[] re3 = solution(arr3, 10);
    }
}
