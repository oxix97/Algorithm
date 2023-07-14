package com.example.programmers.level1;

import java.util.*;
public class level1_모의고사 {
    public static int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        //각 수포자들의 정답 패턴을 배열에 입력

        int x, y, z, count;
        x = y = z = count = 0;
        // 변수 초기화

        for(int i = 0; i < answers.length; i++) {
            //5개씩 반복되는 패턴으로 이루어져 있어서  i%5
            //답안과 수포자의 답안이 맞는 경우 점수 증가
            if(answers[i] == one[i%5]) x++;
            if(answers[i] == two[i%8]) y++;
            if(answers[i] == three[i%10]) z++;
        }

        int[] ans = {x, y, z}; //수포자들 배열에 입력

        Arrays.sort(ans); //오름차순 정렬. 최대값

        ArrayList<Integer> temp = new ArrayList<>();

        //마지막 값이 최대값이라서 동일한 경우 가장 많이 맞힌 수포자다.
        if(x == ans[2]) temp.add(1);
        if(y == ans[2]) temp.add(2);
        if(z == ans[2]) temp.add(3);

        int[] answer = new int[temp.size()];

        for(int i=0;i<answer.length;i++) //temp에 있던 것을 배열에 옮긴다.
            answer[i] = temp.get(i);

        return answer;
    }

    public static void main(String[] args) {
        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {1,3,2,4,2};
        int[] result = solution(answer2);

        for(int i=0;i<result.length;i++)
            System.out.print(result[i]+" ");
    }
}
