import java.util.*;
public class level1_같은숫자는싫어 {
    public static int[] solution(int[] arr) {
        //리스트 선언
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1;i<arr.length;i++) {
            //배열이 i-1번째와 i번째가 겹치는지 확인
            if(arr[i-1] != arr[i])
                list.add(arr[i-1]);
        }

        list.add(arr[arr.length-1]); //마지막 숫자 리스트에 삽입

        int[] answer = new int[list.size()];

        for(int i=0;i<answer.length;i++)
            answer[i] = list.get(i); //리스트 -> 배열로 옮기기

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
