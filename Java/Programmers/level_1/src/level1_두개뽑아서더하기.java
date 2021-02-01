import java.util.*;

public class level1_두개뽑아서더하기 {
        //제한사항 2 <=numbers<= 100
        // 0<=numbers<=100
    public static int[] solution(int[] numbers){
        //겹쳐있는 수를 제거하기 위해 HashSet을 이용합니다.
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length && i != j;j++){
                //i != j 일 경우에 두 수를 더해서 HashSet에 추가한다.
                set.add(numbers[i] + numbers[j]);
            }
        }
        //Iterator를 설정하여 HashSet를 순차적으로 접근할 수 있게 한다.
        Iterator iterator = set.iterator();

        int[] answer = new int[set.size()];
        //set에 담긴 내용을 answer배열로 옮김
        for(int i=0;i< answer.length;i++){
            answer[i] = (int) iterator.next();
        }
        Arrays.sort(answer); //오름차순으로 정렬
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
