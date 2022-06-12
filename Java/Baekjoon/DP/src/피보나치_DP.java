import java.util.Arrays;

public class 피보나치_DP {
    static int[] arr = new int[100];
    static int cnt = 0;
    public static void main(String[] args) {
        Arrays.fill(arr, 0);
        arr[0] = 1;
        arr[1] = 1;
        fibo(30);
        System.out.println(cnt);
    }

    private static int fibo(int x) {
        if (x == 1 || x == 2) return arr[x];
        if (arr[x] != 0) return arr[x];
        cnt += 1;
        arr[x] = fibo(x - 1) + fibo(x - 2);
        return arr[x];
    }
}
