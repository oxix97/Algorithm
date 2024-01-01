package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2477 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int K;
    static int[] width = new int[3];
    static int[] height = new int[3];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        K = Integer.parseInt(br.readLine());
        int h = 0;
        int w = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if (d == 1 || d == 2)
                width[w++] = len;
            else
                height[h++] = len;
        }

        Arrays.sort(width);
        Arrays.sort(height);

        int max = width[2] * height[2];
        int v1 = (height[1] * width[2]) + (height[0] * width[1]);
        int v2 = (height[0] * width[2]) + (width[1] * height[1]);
        int v3 = (height[1] * width[2]) + (height[1] * width[0]);
        int v4 = (height[0] * width[2]) + (width[1] * height[0]);

        if (max - (height[0] * width[0]) == v1) {
            System.out.println(v1 * K);
        } else if (max - (height[0] * width[1]) == v2) {
            System.out.println(v2 * K);
        } else if (max - (height[1] * width[0]) == v3) {
            System.out.println(v1 * K);
        } else if (max - (height[1] * width[1]) == v4) {
            System.out.println(v1 * K);
        }
    }

}

