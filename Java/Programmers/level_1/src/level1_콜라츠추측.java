public class level1_콜라츠추측 {
    public static int solution(int num) {
        int answer = 0;
        long temp = num;
        while(temp != 1) {
            if(answer==500)
                return -1;
            temp = temp%2 == 0 ? temp/2 : 1+(temp*3);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }
}
