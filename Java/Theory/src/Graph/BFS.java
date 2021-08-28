package Graph;

import java.util.*;

public class BFS {
    public ArrayList<String> bfs(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();
        needVisit.add(startNode);
        int count = 0;
        while (needVisit.size() > 0) {
            String node = needVisit.remove(0);
            ++count;
            if(!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(graph.get(node));
                System.out.println(visited);
            }
        }
        System.out.println("count : "+count);
        return visited;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();

        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>(Arrays.asList("D")));
        graph.put("G", new ArrayList<>(Arrays.asList("C")));
        graph.put("H", new ArrayList<>(Arrays.asList("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<>(Arrays.asList("I")));

        System.out.println(graph);
        BFS b = new BFS();
        b.bfs(graph,"A");
    }
}
