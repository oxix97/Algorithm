import java.util.*;
public class 수정렬하기 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int cont = scan.nextInt();
        int[] arr = new int[cont];
        for(int i=0;i<cont;i++)
            arr[i] = scan.nextInt();
        Arrays.sort(arr);
        for(int i=0;i<cont;i++)
            System.out.println(arr[i]);
    }
}
