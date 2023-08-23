package src.sort.topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2056 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] T;
    static int[] T_done;
    static int[] inDegree;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        inputs();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                T_done[i] = T[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) q.add(next);
                T_done[next] = Math.max(T_done[next], T_done[now] + T[next]);
            }
        }

        Arrays.sort(T_done);
        System.out.println(T_done[N]);
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        T_done = new int[N + 1];
        inDegree = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            T[i] = V;
            inDegree[i] = K;
            for (int k = 1; k <= K; k++) {
                int idx = Integer.parseInt(st.nextToken());
                list[idx].add(i);
            }
        }
    }
}
