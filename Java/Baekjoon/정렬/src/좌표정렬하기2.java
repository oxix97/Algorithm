import java.util.*;
public class 좌표정렬하기2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                arr[i][j] = scan.nextInt();
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[1]==t2[1]) return Integer.compare(t1[0],t2[0]);
                else return Integer.compare(t1[1],t2[1]);
            }
        });
        for(int i=0;i<n;i++)
            System.out.println(arr[i][0] + " "+arr[i][1]);
    }
}
