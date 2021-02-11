import java.util.*;
public class 영화감독숌 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int cont = 0;
        while(n!=0) {
            cont++;
            if(String.valueOf(cont).contains("666"))
                n--;
        }
        System.out.println(cont);
    }
}
