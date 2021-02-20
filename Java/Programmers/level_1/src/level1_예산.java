import java.util.*;
public class level1_예산 {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        int temp = budget;
        Arrays.sort(d);

        for (int j : d) {
            if (temp < j)
                continue;
            temp -= j;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
