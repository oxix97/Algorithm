import java.util.Scanner;

public class 두배열의원소교체 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int K;

    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < K; i++) {

            int min = 0;
            int max = 0;


            for (int j = 0; j < A.length; j++) {
                if (A[min] > A[j]) min = j;
                if (B[max] < B[j]) max = j;
            }

            if (A[min] == B[max]) break;

            int temp = A[min];
            A[min] = B[max];
            B[max] = temp;
        }
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        System.out.println(sum);
    }
}
/*
배열 A,B 정의
K번 반복하며
A 최소 값 정의
B 최대 값 정의
서로 스위치
만약 A 최소>=B 최대 인 경우
즉시 종료한다.
* */