import java.util.*;
public class 최댓값 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[9];
        int[] temp = new int[9];
        for(int i=0;i<9;i++){
            arr[i] = scan.nextInt();
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        for(int i=0;i<9;i++){
            if(temp[8]==arr[i]){
                System.out.printf("%d\n%d",temp[8],i+1);
                break;
            }
        }
    }
}
