package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] broken = new boolean[10];
    static String N;
    static int M;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        N = br.readLine();
        M = Integer.parseInt(br.readLine());
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int idx = Integer.parseInt(st.nextToken());
                broken[idx] = true;
            }
        }
        if (N.equals("100")) System.out.println(0);
        else {
            int cnt = Math.abs(100 - Integer.parseInt(N));
            answer = Math.min(answer, cnt);
            dfs("", 0);
            System.out.println(answer);
        }
        br.close();
    }

    private static void dfs(String now, int idx) {
        for (int i = 0; i < 10; i++) {
            if (broken[i]) continue;
            String next = now + i;
            int cnt = Math.abs(Integer.parseInt(N) - Integer.parseInt(next)) + next.length();
            answer = Math.min(answer, cnt);
            if (idx < 6) dfs(next, idx + 1);
        }
    }
}
