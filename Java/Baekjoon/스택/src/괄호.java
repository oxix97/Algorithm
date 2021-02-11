import java.util.*;
public class 괄호 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Stack<String> s = new Stack<>();
        int n = scan.nextInt();
        for(int i=1;i<=n;i++){
            String input = scan.next();
            String ans="YES";
            for(int j=0;j<input.length();j++){
                String temp = input.substring(j,j+1);
                if(temp.equals("(")) s.push("(");
                else{
                    if(s.isEmpty()){
                        ans="NO"; break;
                    }
                    else s.pop();
                }
            }
            if(s.size()!=0) ans="NO";
            System.out.println(ans);
            s.clear();
        }
    }
}
