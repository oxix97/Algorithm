import java.util.Arrays;
import java.util.Scanner;

public class 떡볶이떡만들기 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int start = 0;
        int mid = 0;
        int end = arr.length;
        while (true) {
            int sum = 0;
            mid = (start + end) / 2;
            int height = arr[mid];
            for (int k : arr) {
                int item = k - height;
                if (item > 0) {
                    sum += item;
                }
            }
            if (sum == M) {
                break;
            } else if (sum > M) {
                //더한 값이 크면 절단기 높이가 작음
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(arr[mid]);
    }
}
