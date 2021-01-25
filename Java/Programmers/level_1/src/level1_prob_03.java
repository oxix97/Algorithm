import java.util.*;
public class level1_prob_03 {
    static String solution(String[] participant, String[] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i=0;i<completion.length;i++)
            if(!participant[i].equals(completion[i]))
                return participant[i];
        return participant[i];
    }
    public static void main(String[] args) {
        String[] participant = {"leo","kiki","eden"};
        String[] completion = {"eden","kiki"};

        String result = solution(participant,completion);
        System.out.println(result);
    }

}
