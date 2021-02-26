import java.util.*;
public class level2_주식가격 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length - 1; j++) {
                if (prices[i] > prices[j])
                    break;
                else
                    answer[i]++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] price = {1,2,3,2,3};
        int[] result = solution(price);

        for(int prices : result)
            System.out.println(prices);
    }
}
