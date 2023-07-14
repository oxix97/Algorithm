import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    public static boolean noHashSolution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++)
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;

        return true;
    }

    public static boolean solution(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String phone_number : phone_book) {
            hm.put(phone_number, phone_number.length());
        }

        for (String phone_number : phone_book) {
            for (int i = 0; i < hm.get(phone_number); i++) {
                if (hm.containsKey(phone_number.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] prob1 = {"119", "97674223", "1195524421"};
        String[] prob2 = {"123", "456", "789"};
        String[] prob3 = {"12", "123", "1235", "567", "88"};
        String[][] prob = {prob1, prob2, prob3};

        for (String[] problem : prob) {
            solution(problem);
        }
    }
}
