package src.graph.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기_2252 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] list; // M번 줄세운 입력값
    static int[] arr;

    public static void main(String[] args) throws IOException {
        //1. N (1 ~ 32,000): 학생수 , M(1 ~ 100,000) : 비교 횟수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //2. M개 두 학생의 번호 A,B 입력 -> A가 B 앞에 서야 한다는 의미
        //3. 학생 노드 진입 차수 초기화 및 M번 입력 받을 리스트 초기화
        arr = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            ++arr[B];
        }

        //3. BFS를 통해 각 노드별 진입 차수 구하기
        bfs();

        //출력 : 학생들을 앞에서 부터 줄을 세운 결과- > 키 작은순 (오름차순) 제일 작은 친구가 루트 노드
        System.out.println(sb);

        br.close();
    }

    private static void bfs() {
        //4. 진입 차수가 0인 학생 탐색 후 큐에 삽입
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                q.add(i);
            }
        }

        //5. 진입 차수 0인 노드 출력 및 해당 노드와 연관된 노드 진입 차수 -1
        while (!q.isEmpty()) {
            int x = q.poll();
            append(x);
            for (int nx : list[x]) {
                --arr[nx];
                if (arr[nx] == 0)
                    q.add(nx);
            }
        }
    }

    private static void append(int n) {
        sb.append(n).append(' ');
    }
}
