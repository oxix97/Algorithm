import java.util.*;
public class N과M_1 {
    static int n,m;
    static int[] list;
    static int[] check;
    public static void solution(int cnt) {
        if(cnt==m) {
            for(int i=0;i<m;i++)
                System.out.print(list[i]+" ");
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++) {
            if(check[i]==1) continue;
            check[i]=1;
            list[cnt]=i+1;
            solution(cnt+1);
            check[i]=0;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        check = new int[n];
        list = new int[n];
        solution(0);
    }
}
