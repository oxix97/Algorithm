package Recursion;

public class PowerSet {

    private static final char[] data = {'a', 'b', 'c'};
    private static final int n = data.length;
    private static final boolean[] include = new boolean[n];
    private static int count = 1;

    public static void powerSet(int k) {
        if (k == n) {
            for (int i = 0; i < n; i++)
                if(include[i]) System.out.print(data[i] + " ");
            System.out.println();
            return;
        }
        include[k] = false;
        powerSet(k + 1);
        include[k] = true;
        powerSet(k + 1);
        ++count;
    }

    public static void main(String[] args) {
        powerSet(0);
        System.out.println(count);
    }
}
