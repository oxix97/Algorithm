package src.sw;

import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class 달팽이숫자_1954 {
    static int[] dr = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dc = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            int dir = 0;
            int r = 0, c = 0;
            for (int i = 1; i <= N * N; i++) {
                arr[r][c] = i;
                if (r + dr[dir] >= N || r + dr[dir] < 0 || c + dc[dir] >= N || c + dc[dir] < 0
                        || arr[r + dr[dir]][c + dc[dir]] != 0) {
                    dir = (dir + 1) % 4;
                }
                r += dr[dir];
                c += dc[dir];
            }
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j : arr[i]) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }
}