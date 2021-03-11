import java.util.*;
public class level2_프린터 {

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        int k = 0;
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < priorities.length; i++) {
            hash.put(i, priorities[i]);
            s.push(priorities[i]);
        }
        s.sort(null);
        while(true) {
            if (s.peek().equals(hash.get(k))) {
                if (location == k) {

                    break;
                }
                s.pop();
                hash.remove(k);
                k++;
                answer++;
            } else {
                k++;
            }
            k = k % priorities.length;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }
}
