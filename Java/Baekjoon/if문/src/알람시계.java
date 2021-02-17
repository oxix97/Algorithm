import java.util.*;
public class 알람시계 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int m = scan.nextInt();
        if(m-45<0){
            if(h==0)System.out.printf("23 %d\n",15+m);
            else System.out.printf("%d %d\n",h-1,15+m);
        }
        else System.out.printf("%d %d\n",h,m-45);
    }
}
