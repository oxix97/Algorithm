import java.util.*;
public class 직사각형에서탈출 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int w = scan.nextInt();
        int h = scan.nextInt();
        int mx = x > (w-x) ? (w-x) : x;
        int my = y > (h-y) ? (h-y) : y;
        if(mx>my) System.out.println(my);
        else System.out.println(mx);
        scan.close();
    }
}
