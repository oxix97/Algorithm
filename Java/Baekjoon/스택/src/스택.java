import java.util.*;
public class 스택 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        int n = scan.nextInt();
        for(int i=1;i<=n;i++){
            String input = scan.next();
            switch(input){
                case "push":
                    int num = scan.nextInt();
                    s.push(num); break;
                case "pop":
                    if(s.isEmpty()) System.out.println(-1);
                    else System.out.println(s.pop()); break;
                case "size":
                    System.out.println(s.size()); break;
                case "empty":
                    if(s.isEmpty()) System.out.println(1);
                    else System.out.println(0); break;
                case "top":
                    if(s.isEmpty()) System.out.println(-1);
                    else System.out.println(s.peek()); break;
            }
        }
    }}
