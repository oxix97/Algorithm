import java.util.*;
public class 좌표정렬하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++) {
            for(int j=0;j<2;j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[0]==t2[0]) return Integer.compare(t1[1],t2[1]);
                else return Integer.compare(t1[0],t2[0]);
            }
        });
        for(int i=0;i<n;i++) {
            for(int j=0;j<2;j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
