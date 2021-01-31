import java.util.*;
public class level1_같은숫자는싫어 {
    public static int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=1;i<arr.length;i++) {
            if(arr[i-1] != arr[i])
                list.add(arr[i-1]);
            if(i == arr.length-1)
                list.add(arr[i]);
        }

        int[] answer = new int[list.size()];

        for(int i=0;i<answer.length;i++)
            answer[i] = list.get(i);

        return answer;
    }
    public static void printInfo(int[] answer){
        int[] ans = solution(answer);
        for(int i : ans){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};

        printInfo(arr1);
        printInfo(arr2);

    }
}
