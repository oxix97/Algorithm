package Util;

import java.util.*;

public class UtilClass {

    public void inputRandomValue(ArrayList<Integer> list) {
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 100 + 1));
        }
    }

    public void inputRandomValue(int[] list) {
        for (int i = 0; i < 100; i++) {
            list[i] =(int) (Math.random() * 100 + 1);
        }
    }

    public void printIntegerList(ArrayList<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printIntegerList(int[] list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printStringList(ArrayList<String> list) {
        for (String i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printHashMap(HashMap<String, Integer> map) {
        System.out.println(map);
    }

    public void inputHashMap(HashMap<String, ArrayList<String>> graph) {
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));
    }

    public ArrayList<Integer> inputCoinList() {
        Integer[] temp = {500, 100, 50, 1};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(temp));
        return list;
    }

    public int[][] inputKnapsackList() {
        //첫번째가 무게, 두번째가 가치
        return new int[][]{{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
    }

    public void inputDijkstraPath(HashMap<String, ArrayList<Edge>> graph) {
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
    }

    public static class Edge implements Comparable<Edge> {
        public int distance;
        public String vertex;

        public Edge(int distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        // System.out.println() 으로 객체 자체 출력시,
        public String toString() {
            return "vertex: " + this.vertex + ", distance: " + this.distance;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.distance - edge.distance;
        }
    }
}
