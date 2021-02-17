import java.util.*;
public class 평균은넘겠지 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0;i<n;i++){
            int pn = scan.nextInt();
            double sum = 0;
            double avg = 0;
            double cont = 0;
            double answer = 0;
            int[] arr = new int[pn];
            for(int k=0;k<arr.length;k++){
                arr[k] = scan.nextInt();
                sum += arr[k];
            }
            avg = sum/pn;
            for(int k=0;k<arr.length;k++){
                if(arr[k]>avg){
                    ++cont;
                }
            }
            answer = cont/pn;
            System.out.printf("%.3f%%\n",answer*100);
        }
    }
}
