package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1475 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] nums;
    static String N;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        N = br.readLine();
        nums = new int[10];
        int tmp = 0;
        for (char c : N.toCharArray()) {
            int n = c - '0';
            if (n == 6 || n == 9) ++tmp;
            else ++nums[n];
        }
        Arrays.sort(nums);
        System.out.println(Math.max(Math.round((float) tmp / 2), nums[9]));
    }
}
