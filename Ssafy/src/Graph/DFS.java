package Graph;

import Util.UtilClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DFS {
    static UtilClass util = new UtilClass();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        util.inputHashMap(graph);

        util.printStringList(dfs(graph, "A"));
    }

    public static ArrayList<String> dfs(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisited = new ArrayList<>();

        needVisited.add(startNode);

        while (needVisited.size() > 0) {
            String node = needVisited.remove(needVisited.size() - 1);

            if (!visited.contains(node)) {
                visited.add(node);
                needVisited.addAll(graph.get(node));
            }
        }

        return visited;
    }
}
