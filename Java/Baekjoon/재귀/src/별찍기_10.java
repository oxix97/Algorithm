import java.util.*;
public class 별찍기_10 {
    static char[][] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new char[n][n];
        for(int i=0;i<arr.length;i++)
            Arrays.fill(arr[i],' ');
        solution(0, 0, n);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    public static void solution(int x, int y,int n) {
        int cont = 0;
        if(n==1) {
            arr[x][y]='*'; return;
        }
        cont = n/3;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(i==1&&j==1) continue;
                solution(x+(cont*i),y+(cont*j),cont);
            }
        }
    }
}
