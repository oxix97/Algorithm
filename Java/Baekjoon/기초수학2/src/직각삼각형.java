import java.util.*;
public class 직각삼각형 {
    public static String solution(int w, int l, int h) {
        int[] arr = {w,l,h};
        Arrays.sort(arr);
        int temp = (int)(Math.pow(arr[0], 2) + Math.pow(arr[1], 2));
        if(temp==Math.pow(arr[2], 2))
            return "right";
        return "wrong";
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int w = scan.nextInt();
            int l = scan.nextInt();
            int h = scan.nextInt();
            if(w+l+h==0) break;
            System.out.println(solution(w,l,h));
        }
    }
}
