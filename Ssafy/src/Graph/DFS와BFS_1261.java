package Graph;

import Util.UtilClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DFS와BFS_1261 {
    static Scanner sc = new Scanner(System.in);
    static UtilClass util = new UtilClass();

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int nodes = sc.nextInt();
        int vertex = sc.nextInt();
        int startNode = sc.nextInt();

        for (int i = 1; i <= nodes; i++) {
            graph.put(i, new ArrayList<>(1));
        }

        for (int i = 1; i <= vertex; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();

            //키 있으면 걍 추가, 없으면 리스트 만들고 키에 리스트 추가
            if (graph.containsKey(key)) {
                graph.get(key).add(value);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(value);
                graph.put(key, temp);
            }

            //양방향이기 때문에 서로 연결
            if (graph.containsKey(value)) {
                graph.get(value).add(key);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(value);
                graph.put(value, temp);
            }
        }

        // 정점이 여러개인 경우 작은 정점번호 부터 방문하기 위한 정렬
        for (ArrayList<Integer> list : graph.values()) {
            Collections.sort(list);
        }
        //없으면 종료
        if (vertex == 0) {
            return;
        }
        //초기 노드에 연결된게 없는 경우 하나 출력
        else if (graph.get(startNode) == null) {
            System.out.println(startNode);
        } else {
            result = bfs(graph, startNode);
        }
        util.printIntegerList(result);
    }

    public static ArrayList<Integer> bfs(HashMap<Integer, ArrayList<Integer>> graph, int startNode) {
        ArrayList<Integer> visited = new ArrayList<>();
        ArrayList<Integer> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            int node = needVisit.remove(0);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }
}
