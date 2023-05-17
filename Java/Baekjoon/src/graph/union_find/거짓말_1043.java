package src.graph.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말_1043 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, T;
    static int[] parents;
    static int[] trues;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) throws IOException {
        //1.  N,M입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //2. 거짓말 알고 있는 사람 T명 입력
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        trues = new int[T];
        for (int i = 0; i < T; i++) {
            trues[i] = Integer.parseInt(st.nextToken());
        }

        //3. 파티 참여자 입력
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        //4. 대표 자기 자신으로 초기화
        parents = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        //5. 각 파티 그룹 대표자 선정 -> union(first,others)
        for (int i = 0; i < M; i++) {
            int represent = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(represent, party[i].get(j));
            }
        }

        //6. 각 파티 그룹의 대표자를 통해 진실아는 T배열 탐색
        //7. T배열에 해당 사항이 한개도 없으면 ++cnt
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            boolean isOk = true;
            int cur = party[i].get(0);
            for (int j = 0; j < trues.length; j++) {
                if (find(cur) == find(trues[j])) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) ++cnt;
        }
        //8. 출력
        System.out.println(cnt);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parents[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
}