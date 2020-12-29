import java.util.*;

public class AdjacencyList {

    private int V;
    private LinkedList<Integer> adj[];
    
    public AdjacencyList(int v) {
        V = v;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public int getVercise() {
        return V;
    }

    public LinkedList<Integer> getAdjEle(int i) {
        return adj[i];
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void printGraph() {
        for(int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": head");
            for(Integer v : adj[i]) {
                System.out.print(" -> " + v);
            }
            System.out.println();
        }
    }
}