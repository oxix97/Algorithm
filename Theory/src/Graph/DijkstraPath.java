package Graph;

import java.util.*;

class Edge implements Comparable<Edge> {
    private int distance;
    private String vertex;

    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return "vertex: " + this.vertex + ", distance : " + this.distance;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}

public class DijkstraPath {
    public HashMap<String, Integer> dijkstraFuc(HashMap<String, ArrayList<Edge>> graph, String start) {
        HashMap<String, Integer> distance = new HashMap<>();
        for (String key : graph.keySet()) {
            distance.put(key, Integer.MAX_VALUE);
        }
        distance.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distance.get(start), start));

        return distance;
    }
    public static void main(String[] args) {
        DijkstraPath dObject = new DijkstraPath();
        HashMap<String,ArrayList<Edge>> graph = new HashMap<>();
        HashMap<String,Integer> result;
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<>(Collections.singletonList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<>(Collections.singletonList(new Edge(5, "A"))));
        result = dObject.dijkstraFuc(graph,"A");

        System.out.println(result);
    }
}
