import java.util.*;
public class level1_소수찾기 {
    public static int solution(int n) {
        ArrayList<Boolean> ary = new ArrayList<>();

        // 0과 1은 소수가 아니기때문에 먼저 false처리 합니다.
        ary.add(false);
        ary.add(false);

        //0,1을 제외한 나머지 모든 수에게 true 부여
        for(int i=2; i<=n;i++)	ary.add(i,true);

        //2부터 n의 제곱근까지 반복
        for(int i=2; (i*i) <= n; i++)
            // i*2는 짝수이므로 모두 소수가 되지 못한다.
            for(int j=i*2; j<=n ; j+=i)
                if(ary.get(j)) 	ary.set(j,false); //소수가 아니므로 false

        int answer = 0;

        for(int i=2; i<=n;i++)
            if(ary.get(i)) answer++; //리스트에 true값 개수

        return answer;
    }

    public static void main(String[] args) {
        int a = solution(10);
        System.out.println(a);
    }
}
