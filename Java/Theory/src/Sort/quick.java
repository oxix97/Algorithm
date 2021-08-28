package Sort;

import java.util.*;
import java.math.*;

public class quick {
    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        if(list.size()<=1) return list;
        int pivot = list.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if(pivot>list.get(i)){
                left.add(list.get(i));
            }else{
                right.add(list.get(i));
            }
        }

        ArrayList<Integer> mergeList = new ArrayList<>();
        mergeList.addAll(this.sort(left));
        mergeList.addAll(Collections.singletonList(pivot));
        mergeList.addAll(this.sort(right));

        return mergeList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<100;i++){
            arr.add((int) (Math.random()*100));
        }
        quick q = new quick();
        arr = q.sort(arr);
        System.out.println(arr);

    }
}
