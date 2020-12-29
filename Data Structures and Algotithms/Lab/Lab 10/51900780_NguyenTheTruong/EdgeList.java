import java.util.Vector;

class EdgeList {

    private Vector<IntegerTriple> edges;

    public EdgeList() {
        edges = new Vector<IntegerTriple>();
    }

    public Vector<IntegerTriple> getEdge() {
        return edges;
    }
    
    public IntegerTriple getEdgeEle(int n) {
        return edges.get(n);
    }
    public void addEdge(int u, int v, int w) {
        edges.add(new IntegerTriple(u, v, w));
    }

    public void addEdge(IntegerTriple e) {
        edges.add(e);
    }

    public int getSize() {
        return edges.size();
    }

    public IntegerTriple removeEdge(int i) {
        IntegerTriple e = edges.get(i);
        edges.remove(edges.get(i));
        return e;
    }

    public void printGraph() {
        System.out.println(" u\tv\tw");
        System.out.println(" ----------------");
        for(int i = 0; i < edges.size(); i++) {
            System.out.println(edges.get(i));
        }
    }
}