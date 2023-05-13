package src.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class 트리의지름_1167 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int V;
    static boolean[] visited;
    static int[] distances;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void inputs() throws IOException {
        V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];
        distances = new int[V + 1];

        for (int i = 0; i <= V; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int iNode = line[0];
            for (int j = 1; j < line.length - 1; j += 2) {
                list[iNode].add(new Node(line[j], line[j + 1]));
            }
        }
    }

    private static void solution() {
        bfs(1);
        int max = getMax("idx");
        Arrays.fill(visited, false);
        Arrays.fill(distances, 0);
        bfs(max);
        sb.append(getMax("value"));
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;
        q.add(n);

        while (!q.isEmpty()) {
            int now_node = q.poll();
            for (Node node : list[now_node]) {
                if (!visited[node.idx]) {
                    visited[node.idx] = true;
                    distances[node.idx] = distances[now_node] + node.distance;
                    q.add(node.idx);
                }
            }
        }
    }

    private static int getMax(String command) {
        int max = 0;
        int idx = 0;
        for (int i = 1; i <= V; i++) {
            if (max < distances[i]) {
                max = distances[i];
                idx = i;
            }
        }
        if (command.equals("value"))
            return max;
        else
            return idx;
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    private static void appendVertical(Object obj) {
        sb.append(obj).append('\n');
    }

    private static void appendHorizontal(Object obj) {
        sb.append(obj).append(' ');
    }
}

class Node {
    int idx;
    int distance;

    public Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }
}
