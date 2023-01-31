import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Strahler순서_9470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, K, M, P;
    static ArrayList<Integer>[] inlist;
    static ArrayList<Integer>[] outlist;
    //    static int[] indegree;
    static int[] outdegree;
    static ArrayList<Integer> order;
    static int[] result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            inputs();
            solution();
            sb.append(i).append(' ').append(result[M]).append('\n');
        }
        System.out.println(sb);
    }

    private static void solution() {
        inputOrder();
        outputStrahler();
    }

    private static void outputStrahler() {
        for (int i = 1; i <= M; i++) {
            int n = order.get(i - 1);
            if (inlist[n].isEmpty()) {
                continue;
            } else if (inlist.length == 1) {
                int idx = inlist[n].get(0);
                result[n] = result[idx];
            } else {
                int cnt = 0;
                int max = 0;

                for (int x : inlist[n]) {
                    int num = result[x];
                    if (max < num) {
                        max = num;
                        cnt = 1;
                    } else if (max == num) ++cnt;
                }

                result[n] = max + cnt - 1;
            }
        }
    }

    private static void inputOrder() {
        Queue<Integer> q = new LinkedList<>();
        order.clear();

        for (int i = 1; i <= M; i++)
            if (outdegree[i] == 1) q.add(i);

        while (!q.isEmpty()) {
            int n = q.poll();
            order.add(n);
            for (int x : outlist[n]) {
                outdegree[x]--;
                if (outdegree[x] == 1) {
                    q.add(x);
                }
            }
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        outlist = new ArrayList[M + 1];
        inlist = new ArrayList[M + 1];
//        indegree = new int[M + 1];
        outdegree = new int[M + 1];
        order = new ArrayList<>();
        result = new int[M + 1];

        for (int i = 0; i <= M; i++) {
            inlist[i] = new ArrayList<>();
            outlist[i] = new ArrayList<>();
        }

        Arrays.fill(outdegree, 1);
        Arrays.fill(result, 1);

        for (int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            outlist[A].add(B);
            inlist[B].add(A);
//            indegree[A]++;
            outdegree[B]++;
        }
    }
}