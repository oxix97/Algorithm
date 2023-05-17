package src.graph.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발_1516 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] list;
    static int[] inDegree;
    static int N;
    static int[] times;
    static int[] selfTimes;

    public static void main(String[] args) throws IOException {

        //1.  N(1~500) : 건물의 종류 수, N번 반복, 번호 1 ~ N, 입력 받는 list 1~ N
        //times : 건물 지어지는데 걸리는 시간, inDegree : 먼저 선행 건물 개수
        N = Integer.parseInt(br.readLine());
        inDegree = new int[N + 1];
        list = new ArrayList[N + 1];
        selfTimes = new int[N + 1];
        times = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            selfTimes[i] = time;
            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) {
                    break;
                }
                list[n].add(i);
                inDegree[i]++;
            }
        }

        //2. bfs를 통해 차수가 0인거 부터 건물 짓는다.
        bfs();

        //출력
        for (int i = 1; i <= N; i++) {
            append(times[i] + selfTimes[i]);
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                --inDegree[next];
                times[next] = Math.max(times[next], times[now] + selfTimes[now]);
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }

    private static void append(int n) {
        sb.append(n).append('\n');
    }
}
