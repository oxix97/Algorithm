import java.util.*;
public class 상수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        String[] temp = new String[2];
        for(int i=2;i>=0;i--) {
            temp[0] += Integer.toString(a).substring(i, i+1);
            temp[1] += Integer.toString(b).substring(i, i+1);
        }
        temp[0] = temp[0].substring(4, 7);
        temp[1] = temp[1].substring(4, 7);
        if(Integer.parseInt(temp[0])>Integer.parseInt(temp[1]))
            System.out.println(temp[0]);
        else
            System.out.println(temp[1]);
    }
}
