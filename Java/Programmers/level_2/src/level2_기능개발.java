import java.util.*;
public class level2_기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int i=0;
        int[] days = new int[speeds.length];
        while(count != speeds.length) {
            if(progresses[i]<100) {
                progresses[i] +=speeds[i];
                days[i]++;
            }
            else {
                i++;
                count++;
            }
        }
        for(int k=1;k<days.length;k++) {
            if(days[k-1]>days[k])
                days[k] = days[k-1];

        }
        for(int k=0;k<days.length;k++) {
            int num = 1;
            for(int j=k+1;j<days.length;j++) {
                if(days[k]==days[j]) {
                    num++;
                    k++;
                }
            }
            list.add(num);
        }
        int[] answer = new int[list.size()];
        for(int k=0;k<answer.length;k++)
            answer[k] = list.get(k);
        return answer;
    }

    public static void main(String[] args) {
        
    }
}
