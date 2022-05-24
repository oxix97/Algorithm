package Graph;

import Util.UtilClass;

import java.util.ArrayList;
import java.util.HashMap;

public class BFS {
    public static void main(String[] args) {
        UtilClass util = new UtilClass();
        HashMap<String, ArrayList<String>> graph = new HashMap<>();

        util.inputHashMap(graph);

        System.out.println(graph);

        ArrayList<String> list = bfs(graph, "A");

        util.printStringList(list);
    }

    public static ArrayList<String> bfs(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisited = new ArrayList<>();

        needVisited.add(startNode);

        while (needVisited.size() > 0) {
            String node = needVisited.remove(0);

            if (!visited.contains(node)) {
                visited.add(node);
                needVisited.addAll(graph.get(node));
            }
        }

        return visited;
    }
}
