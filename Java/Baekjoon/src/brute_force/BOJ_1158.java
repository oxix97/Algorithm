package src.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> q = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int piv = 1;
        int idx = 0;
        sb.append('<');
        while (q.size() != 1) {
            if (piv == K) {
                sb.append(q.remove(idx)).append(',').append(' ');
                piv = 0;
                idx -= 1;
            }
            ++piv;
            idx = (idx + 1) % q.size();
        }
        sb.append(q.remove(0)).append('>');
        System.out.println(sb);
        br.close();
    }
}
