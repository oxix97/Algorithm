import java.util.*;
import java.io.*;
import java.util.stream.*;
public class level1_나누어떨어지는숫자배열 {
    public static int[] solution(int[] arr, int divisor){
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        int[] answer;
        if(list.isEmpty()) answer = new int[] {-1};
        else{
            answer = new int[list.size()];
            Collections.sort(list);
            for(int i=0;i<answer.length;i++) answer[i] = list.get(i);
        }
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
