import java.util.Scanner;

public class 부품찾기 {
    static Scanner sc = new Scanner(System.in);
    static int[] nArr;
    static int[] mArr;

    public static void main(String[] args) {
        int N = sc.nextInt();
        nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        mArr = new int[M];
        for (int i = 0; i < M; i++) {
            mArr[i] = sc.nextInt();
        }

        for (int item : mArr) {
            binarySearch(0, nArr.length - 1, item);
        }

    }

    private static void binarySearch(int start, int end, int item) {
        if (start > end) {
            System.out.print("no ");
            return;
        }

        int mid = (start + end) / 2;

        if (nArr[mid] == item) {
            System.out.print("yes ");
        } else if (nArr[mid] > item) {
            binarySearch(start, mid-1, item);
        } else if (nArr[mid] < item) {
            binarySearch(mid+1, end, item);
        }
    }
}
