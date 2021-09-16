package Recursion;

import java.util.ArrayList;

public class N_queen {
    public static boolean isTrue(ArrayList<Integer> list, int col) {
        int row = list.size();
        for (int i = 0; i < row; i++) {
            if (list.get(i) == col || Math.abs(list.get(i) - col) == row - i) return false;
        }
        return true;
    }
    public static void dfs(int N, int row, ArrayList<Integer> list) {
        if (list.size() == N) {
            System.out.println(list);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isTrue(list, i)) {
                list.add(i);
                dfs(N,row+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(n,0,list);
    }
}
