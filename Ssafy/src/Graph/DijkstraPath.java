package Graph;

import Util.UtilClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {
    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<UtilClass.Edge>> graph, String start) {
        ArrayList<UtilClass.Edge> nodeList;

        HashMap<String, Integer> distances = new HashMap<String, Integer>();

        //키 값을 가져와서 MAX_VALUE로 초기화
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        //시작점을 선언
        distances.put(start, 0);

        //우선 순위 큐 초기화, 시작 노드 삽입
        PriorityQueue<UtilClass.Edge> priorityQueue = new PriorityQueue<UtilClass.Edge>();
        priorityQueue.add(new UtilClass.Edge(distances.get(start), start));

        // 알고리즘 작성
        while (priorityQueue.size() > 0) {
            UtilClass.Edge edgeNode;

            edgeNode = priorityQueue.poll();
            int currentDistance = edgeNode.distance;
            String currentNode = edgeNode.vertex;

            //이미 존재하는 노드의 거리보다 크면 continue
            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            nodeList = graph.get(currentNode);

            for (int index = 0; index < nodeList.size(); index++) {
                UtilClass.Edge adjacentNode = nodeList.get(index);
                String adjacent = adjacentNode.vertex;
                int weight = adjacentNode.distance;
                int distance = currentDistance + weight;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new UtilClass.Edge(distance, adjacent));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        UtilClass util = new UtilClass();
        HashMap<String, ArrayList<UtilClass.Edge>> map = new HashMap<>();
        util.inputDijkstraPath(map);
        util.printHashMap(new DijkstraPath().dijkstraFunc(map, "A"));
    }
}