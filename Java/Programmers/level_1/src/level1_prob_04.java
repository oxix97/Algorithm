import java.util.*;
public class level1_prob_04 {
    public static int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        //각 수포자들의 정답 패턴을 배열에 입력

        int x, y, z, count;
        x = y = z = count = 0;
        // 변수 초기화

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%5]) x++; //5개씩 반복되는 패턴으로 이루어져 있어서  i%5
            if(answers[i] == two[i%8]) y++;
            if(answers[i] == three[i%10]) z++;
        }
        //답안과 수포자의 답안이 맞는 경우 점수 증가

        int[] ans = {x, y, z};

        Arrays.sort(ans); //오름차순 정렬. 최대값

        ArrayList<Integer> temp = new ArrayList<>();

        //마지막 값과 같으면 문제를 많이 맞췄다 하여 증가
        if(x == ans[2]) temp.add(1);
        if(y == ans[2]) temp.add(2);
        if(z == ans[2]) temp.add(3);

        int[] answer = new int[temp.size()];
        for(int num : temp) {
            answer[count] = temp.get(count);
            count++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = {1,2,3,4,5};
        int[] result = solution(answer);

        for(int i=0;i<result.length;i++) System.out.println(result[i]);


    }
}
