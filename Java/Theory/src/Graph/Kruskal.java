package Graph;
import java.util.*;

class Edgee implements Comparable<Edgee>{
    private int weight;
    private String nodeV;
    private String nodeU;

    public Edgee(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public String toString(){
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(Edgee o) {
        return this.weight-o.weight;
    }
}

public class Kruskal {

}
