import java.io.*;

public class Exercise2 {

    // Read the graph from the file and print the AL on the screen.
    public static AdjacencyList readFile(String path) {
        try {
            File input = new File(path);
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            int size = Integer.parseInt(br.readLine());
            AdjacencyList AL = new AdjacencyList(size);
            int i = 0;
            String line;
            while((line = br.readLine()) != null) {
                String[] val = line.split(" ");
                for(int j = 1; j < val.length; j++) {
                    AL.addEdge(i, Integer.parseInt(val[j]));
                }
                i++;
            }
            fr.close();
            br.close();
            return AL;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void print(AdjacencyList AL) {
        AL.printGraph();
    }

    // Count the number of vertices.
    public static int countVertice(AdjacencyList AL) {
        return AL.getVercise();
    }

    // Count the number of edges.
    public static int countEdge(AdjacencyList AL) {
        int count = 0;
        for(int i = 0; i < countVertice(AL); i++) {
            for(int j = 0; j < AL.getAdjEle(i).size(); j++) {
                count ++;
            }
        }
        return count/2;
    }

    // Enumerate neighbors of a vertex u.
    public static void getNeighbor(AdjacencyList AL, int n) {
        System.out.print("Enumerate neighbors of a vertex " + n + ": ");
        for(int i = 0; i < AL.getAdjEle(n-1).size(); i++) {
            System.out.print((AL.getAdjEle(n-1).get(i) + 1) + " ");
        }
        System.out.println();
    }

    // Check the existence of edge (u, v).
    public static boolean checkExist(AdjacencyList AL, int u, int v) {
        for(int item : AL.getAdjEle(u-1)) {
            if(item == (v-1)) {
                return true;
            }
        }
        return false;
    }

    // Main
    public static void main(String[] args) {
        AdjacencyList AL = readFile("Input2.txt");
        print(AL);
        System.out.println("Number of vertice: " + countVertice(AL));
        System.out.println("Number of edge: " + countEdge(AL));
        getNeighbor(AL, 5);
        System.out.println("Check the existence of edge (4, 2): " + checkExist(AL, 4, 2));
    }
}