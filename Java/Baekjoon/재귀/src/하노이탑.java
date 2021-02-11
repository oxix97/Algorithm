import java.util.*;
public class 하노이탑 {
    static int cont = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        move(n,1,3);
        System.out.println(cont);
        System.out.println(sb);
    }
    public static void move(int n, int x, int y) {
        cont++;
        if(n>1) move(n-1,x,6-x-y);
        sb.append(x+" "+y+"\n");
        if(n>1) move(n-1,6-x-y,y);
    }
}
