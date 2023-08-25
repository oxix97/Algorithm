package src.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static int A, B;
    static Queue<Integer> q;
    static String[] command;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            command = new String[10000];
            visited = new boolean[10000];
            Arrays.fill(command, "");
            q.add(A);
            visited[A] = true;
            while (!q.isEmpty()) {
                int now = q.poll();

                int D = (now * 2) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (!visited[D]) {
                    command[D] = command[now] + "D";
                    q.add(D);
                    visited[D] = true;
                }
                if (!visited[S]) {
                    command[S] = command[now] + "S";
                    q.add(S);
                    visited[S] = true;
                }
                if (!visited[L]) {
                    command[L] = command[now] + "L";
                    q.add(L);
                    visited[L] = true;
                }
                if (!visited[R]) {
                    command[R] = command[now] + "R";
                    q.add(R);
                    visited[R] = true;
                }
            }
            sb.append(command[B]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
