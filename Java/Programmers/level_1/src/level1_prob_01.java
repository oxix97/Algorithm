import java.lang.reflect.Array;
import java.util.*;

public class level1_prob_01 {
        //제한사항 2 <=numbers<= 100
        // 0<=numbers<=100
    public static int[] solution(int[] numbers){
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length && i != j;j++){
                list.add(numbers[i] + numbers[j]);
            }
        }

        HashSet<Integer> set = new HashSet<>(list);
        Iterator iterator = set.iterator();
        answer = new int[set.size()];

        for(int i=0;i< answer.length;i++){
            answer[i] = (int) iterator.next();
        }
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for(int i=0;i< numbers.length;i++){
            numbers[i] = scanner.nextInt();
        }

        int[] result  = solution(numbers);

        for(int i : result) System.out.printf("%d ",i);
    }
}
