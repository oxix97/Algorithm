package src.sort.topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2637 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] inDegree;
    static int[] needToys;

    static ArrayList<Toy>[] list;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        inputs();
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        needToys[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Toy next : list[now]) {
                needToys[next.num] += needToys[now] * next.cnt;
                inDegree[next.num]--;
                if (inDegree[next.num] == 0)
                    q.add(next.num);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (list[i].isEmpty())
                sb.append(i).append(' ').append(needToys[i]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
        needToys = new int[N + 1];
        inDegree = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[x].add(new Toy(y, k));
            inDegree[y]++;
        }
    }

    static class Toy {
        int num, cnt;

        public Toy(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
