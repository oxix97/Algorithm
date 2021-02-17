import java.util.*;
public class 부녀회장이될테야 {
    public static int solution(int f, int r){
        int answer=  0;
        int[][] arr = new int[f+1][r];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i>0 && j>0) arr[i][j] = arr[i][j-1] + arr[i-1][j];
                else if(i==0) arr[i][j] = j+1;
                else if(j==0) arr[i][j] = 1;
            }
        }
        answer = arr[f][r-1];
        return answer;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0;i<n;i++){
            int f = scan.nextInt();
            int r = scan.nextInt();
            System.out.println(solution(f,r));
        }
    }
}
