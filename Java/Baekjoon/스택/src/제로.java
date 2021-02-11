import java.util.*;
public class 제로 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        int n = scan.nextInt();
        int sum = 0;
        for(int i=1;i<=n;i++){
            int input = scan.nextInt();
            if(input==0)
                sum-=s.pop();
            else{
                sum+=input;
                s.push(input);
            }
        }
        System.out.println(sum);
    }
}
