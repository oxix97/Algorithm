import java.util.*;
public class 더하기사이클 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int front = 0;
        int back = 0;
        int temp = 0;
        int answer = 0;

        front = n/10;
        back = n%10;

        while(true) {
            temp = back;
            back = (front+back)%10;
            front = temp;
            answer++;
            if(n==front*10 + back) break;
        }
        System.out.println(answer);
    }
}
