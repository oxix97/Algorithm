package src.graph.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현_1717 {
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
    static int[][] arr;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1][3];
        nums = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = operator;
            arr[i][1] = a;
            arr[i][2] = b;
        }
    }

    private static void solution() {
        initNums();
        for (int i = 1; i <= M; i++) {
            if (arr[i][0] == 0) {
                union(arr[i][1], arr[i][2]);
            } else {
                appendVertical(isCheck(arr[i][1], arr[i][2]));
            }
        }
    }

    private static void initNums() {
        for (int i = 1; i <= N; i++) {
            nums[i] = i;
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            nums[b] = a;
    }

    private static int find(int a) {
        if (a == nums[a]) return a;
        return nums[a] = find(nums[a]);
    }

    private static String isCheck(int a, int b) {
        return find(a) == find(b) ? "YES" : "NO";
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}
