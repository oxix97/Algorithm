import java.util.*;
public class level1_체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] clothes = new int[n];

        for(int l : lost)
            clothes[l-1]--;

        for(int r : reserve)
            clothes[r-1]++;

        for(int i=0;i<n;i++) {
            if(clothes[0]==-1 && clothes[1]==1) {
                clothes[0]++;
                clothes[1]--;
            }

            else if(clothes[n-1]==-1 && clothes[n-2]==1) {
                clothes[n-2]--;
                clothes[n-1]++;
            }

            else if(clothes[i]==-1) {
                if(i>0 &&clothes[i-1]==1 ) {
                    clothes[i-1]--;
                    clothes[i]++;
                }
                else if(i!=n-1 &&clothes[i+1]==1) {
                    clothes[i+1]--;
                    clothes[i]++;
                }
            }

            if(clothes[i]==-1)
                answer--;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int answer = solution(n,lost,reserve);

        System.out.println("answer : "+answer);
    }
}
