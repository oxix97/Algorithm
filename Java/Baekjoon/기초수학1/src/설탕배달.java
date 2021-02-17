import java.util.*;
public class 설탕배달 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> list = new Stack<>();
        int n = scan.nextInt();
        if(n%5==0) {
            System.out.println(n/5);
            return;
        }
        for(int i=0;i<n/3;i++) {
            int temp=i*5;
            for(int j=0;temp<n;j++) {
                temp = (i*5) + (j*3);
                if(temp==n)
                    list.add(i+j);
            }
        }
        if(list.isEmpty())
            System.out.println(-1);
        else
            System.out.println(list.pop());
    }
}
