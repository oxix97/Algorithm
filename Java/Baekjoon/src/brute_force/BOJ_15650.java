package src.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M(2)
public class BOJ_15650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        combination(1, M);
        System.out.println(sb);
        br.close();
    }

    private static void combination(int start, int m) {
        if (m == 0) {
            for (int i = 1; i <= N; i++) {
                if (visited[i]) sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i <= N; i++) {
            visited[i] = true;
            combination(i + 1, m - 1);
            visited[i] = false;
        }
    }
}
