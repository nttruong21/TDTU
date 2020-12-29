import java.io.*;
import java.util.ArrayList;

public class Exercise3 {

    // Read the graph from the file and print the EL on the screen.
    public static EdgeList readFile(String path) {
        try {
            File input = new File(path);
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            EdgeList EL = new EdgeList();
            String line;
            while((line = br.readLine()) != null) {
                String[] val = line.split(" ");
                EL.addEdge(Integer.parseInt(val[0]), Integer.parseInt(val[1]), Integer.parseInt(val[2]));
            }
            fr.close();
            br.close();
            return EL;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void print(EdgeList EL) {
        EL.printGraph();
    }

    // Count the number of vertices.
    public static int countVertice(EdgeList EL) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        boolean checkSourceExist = false, checkDestExist = false;
        for(IntegerTriple list : EL.getEdge()) {
            int u = list.getSource();
            int v = list.getDest();
            checkDestExist = false;
            checkSourceExist = false;
            for(int item : arr) {
                if(item == u) {
                    checkSourceExist = true;
                }
                if(item == v) {
                    checkDestExist = true;
                }
            }
            if(!checkSourceExist) {
                arr.add(u);
            }
            if(!checkDestExist) {
                arr.add(v);
            }
        }
        return arr.size();
    }

    // Count the number of edges.
    public static int countEdge(EdgeList EL) {
        return EL.getEdge().size();
    }

    // Enumerate neighbors of a vertex u.
    public static ArrayList<Integer> getNeighbor(EdgeList EL, int u) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(IntegerTriple list : EL.getEdge()) {
            if(list.getSource() == u) {
                arr.add(list.getDest());
            }
            if(list.getDest() == u) {
                arr.add(list.getSource());
            }
        }
        return arr;
    }

    // Check the existence of edge (u, v).
    public static boolean checkExist(EdgeList EL, int u, int v) {
        for(IntegerTriple list : EL.getEdge()) {
            if((list.getSource() == u && list.getDest() == v) || (list.getSource() == v && list.getDest() == u)) {
                return true;
            }
        }
        return false;
    }

    // Main 
    public static void main(String[] args) {
        EdgeList EL = readFile("Input3.txt");
        print(EL);
        System.out.println("Number of vertice: " + countVertice(EL));
        System.out.println("Number of edge: " + countEdge(EL));
        System.out.println("Enumerate neighbors of a vertex 1: " + getNeighbor(EL, 1));
        System.out.println("Check the existence of edge (0, 4): " + checkExist(EL, 0, 4));
    }
}