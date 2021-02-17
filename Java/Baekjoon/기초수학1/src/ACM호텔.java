import java.util.*;
public class ACM호텔 {
    public static int solution(int h,int w,int num) {
        int answer =0;
        if(num%h!=0)
            answer = ((num%h)*100) + (num/h)+1;
        else
            answer = (100*h)+ (num/h);
        return answer;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=1;i<=n;i++) {
            int h = scan.nextInt();
            int w = scan.nextInt();
            int num = scan.nextInt();
            System.out.println(solution(h,w,num));
        }
        scan.close();
    }
}
