package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class EdgeClass implements Comparable<EdgeClass>{
    int weight;
    String node1,node2;

    public EdgeClass(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public int compareTo(EdgeClass o) {
        return this.weight - o.weight;
//        return o.weight-this.weight;
    }
    public String toString() {
        return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
    }
}
public class Prim {

    public static void main(String[] args) {
//        PriorityQueue<EdgeClass> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(new EdgeClass(2,"A","B"));
//        priorityQueue.add(new EdgeClass(5,"B","D"));
//        priorityQueue.add(new EdgeClass(3,"C","A"));
//        while (priorityQueue.size() > 0) {
//            System.out.println(priorityQueue.poll());
//        }
//        HashMap<String, ArrayList<EdgeClass>> hashMap = new HashMap<>();
//        hashMap.put("A",new ArrayList<EdgeClass>());
//        hashMap.put("B",new ArrayList<EdgeClass>());
        ArrayList<EdgeClass> myedges = new ArrayList<>();
        myedges.add(new EdgeClass(7, "A", "B"));
        myedges.add(new EdgeClass(5, "A", "D"));
        myedges.add(new EdgeClass(8, "B", "C"));
        myedges.add(new EdgeClass(9, "B", "D"));
        myedges.add(new EdgeClass(7, "D", "E"));
        myedges.add(new EdgeClass(5, "C", "E"));
        myedges.add(new EdgeClass(7, "B", "E"));
        myedges.add(new EdgeClass(6, "D", "F"));
        myedges.add(new EdgeClass(8, "E", "F"));
        myedges.add(new EdgeClass(9, "E", "G"));
        myedges.add(new EdgeClass(11, "F", "G"));

    }
//    public ArrayList<EdgeClass> primFunc(String startNode,ArrayList<EdgeClass> edges) {
//        EdgeClass currentEdge, popedEdge,adjacentEdgeNode;
//        ArrayList<EdgeClass> currentEdgeList,candidateEdgeList, adjacentEdgeNodes;
//        PriorityQueue<EdgeClass> priorityQueue;
//
//        ArrayList<String> connectedNodes = new ArrayList<>();
//        ArrayList<EdgeClass> mst = new ArrayList<>();
//        HashMap<String,ArrayList<EdgeClass>> adjacentEdges = new HashMap<>();
//
//        for (int index = 0; index < edges.size(); index++) {
//            currentEdge = edges.get(index);
//            if (!adjacentEdges.containsKey(currentEdge.node1)) {
//                adjacentEdges.put(currentEdge.node1,new ArrayList<>());
//            }
//            if (!adjacentEdges.containsKey(currentEdge.node2)) {
//                adjacentEdges.put(currentEdge.node2,new ArrayList<>());
//            }
//        }
//
//    }

}
