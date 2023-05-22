package src.basic;

import java.util.*;
public class 단어의개수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringTokenizer st = new StringTokenizer(str," ");
        int n = st.countTokens();
        System.out.println(n);
    }
}
