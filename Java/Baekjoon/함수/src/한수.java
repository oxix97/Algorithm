import java.util.*;
public class 한수 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n<100){
            System.out.println(n);
            return;
        }
        else{
            int answer = 99;
            for(int k=100;k<=n;k++){
                String temp = Integer.toString(k);
                int[] arr = new int[temp.length()];
                for(int i=0; i<arr.length;i++)
                    arr[i] = Integer.parseInt(temp.substring(i,i+1));
                int d = arr[1]-arr[0];
                int cont = 0;
                for(int i=arr.length-1;i>=1;i--){
                    if(d != (arr[i]-arr[i-1])){
                        cont=1;
                        break;
                    }
                    else
                        cont=2;
                }
                if(cont==2)
                    answer+=1;
            }
            System.out.println(answer);
        }
    }
}
