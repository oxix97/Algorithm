package src.basic;

import java.util.*;
public class 크로아티아알파벳 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] alpa = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(int i=0; i<alpa.length;i++)
            if(str.contains(alpa[i]))
                str = str.replaceAll(alpa[i], "a");
        System.out.println(str.length());
    }
}
