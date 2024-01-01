package src.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] count;

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
        arr = new int[101];
        visited = new boolean[101];
        count = new int[101];

        for (int i = 1; i <= N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from] = to;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == 100) {
                System.out.println(count[now]);
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next > 100) continue;
                if (visited[next]) continue;
                visited[next] = true;

                if (arr[next] != 0) {
                    if (!visited[arr[next]]) {
                        q.add(arr[next]);
                        visited[arr[next]] = true;
                        count[arr[next]] = count[now] + 1;
                    }
                } else {
                    q.add(next);
                    count[next] = count[now] + 1;
                }
            }
        }
        br.close();
    }
}
