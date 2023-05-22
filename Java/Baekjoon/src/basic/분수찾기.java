package src.basic;

import java.util.*;
public class 분수찾기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        list.add(i);
        for(i=1;;i++) {
            list.add(i,list.get(i-1)+i);
            if(list.get(i)>=n)
                break;
        }
        int value = list.get(i);
        if(i%2!=0)
            System.out.printf("%d/%d\n",value+1-n,i-(value-n));
        else
            System.out.printf("%d/%d\n",i-(value-n),value+1-n);
    }
}
