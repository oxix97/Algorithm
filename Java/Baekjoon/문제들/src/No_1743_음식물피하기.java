import java.util.*;
import java.math.*;
public class No_1743_음식물피하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 가로길이
        int m = scanner.nextInt(); // 세로길이
        int k = scanner.nextInt(); // 음식물 쓰레기의 개수
        boolean[][] arr = new boolean[Math.min(n,m)][Math.max(n,m)];

        for (int i = 0; i < k; i++) {
            //쓰레기 위치 부여
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            arr[r-1][c-1] = true;
        }

        int[] arrR = new int[arr.length];
        int[] arrC = new int[arr[0].length];

        for (int i = 0; i < Math.min(n,m); ++i) {
            int trash = 0;
            for (int j = 0; j < Math.max(n,m); ++j) {
                if(arr[i][j]) ++trash;
            }
            arrR[i] = trash;
        }

        for (int i = 0; i < Math.max(n,m); ++i) {
            int trash = 0;
            for (int j = 0; j < Math.min(n, m); ++j) {
                if(arr[j][i]) ++ trash;
            }
            arrC[i] = trash;
        }

        for (boolean[] booleans : arr) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean + " ");
            }
            System.out.println();
        }


        for(int i : arrR)
            System.out.print(i + " ");
        System.out.println();
        for(int i : arrC)
            System.out.print(i + " ");
        System.out.println();
    }
}
