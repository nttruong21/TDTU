import java.io.*;

public class Exercise1 {

    // Read the graph from the file and print the AM on the screen.
    public static AdjacencyMatrix readFile(String path) {
        try {
            File input = new File(path);
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            int size = Integer.parseInt(br.readLine());
            AdjacencyMatrix AM = new AdjacencyMatrix(size);
            String line;
            int i = 0;
            while((line = br.readLine()) != null) {                 
                String[] val = line.split(" ");
                for(int j = 0; j < val.length; j++) {
                    AM.setEdge(i, j, Integer.parseInt(val[j]));
                }
                i++;
            }
            fr.close();
            br.close();
            return AM;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void print(AdjacencyMatrix AM) {
        AM.printGraph();
    }

    // Count the number of vertices.
    public static int countVertice(AdjacencyMatrix AM) {
        return AM.getVertice();
    }  

    // Count the number of edges.
    public static int countEdge(AdjacencyMatrix AM) {
        int count = 0;
        for(int i = 0; i < AM.getVertice(); i++) {
            for(int j = 0; j < AM.getVertice(); j++) {
                if(AM.getEdge(i, j) == 1) {
                    count ++;
                }
            }
        }
        if(count > 1) {
            count /= 2;
        }
        return count;
    }

    // Enumerate neighbors of a vertex u.
    public static void getNeighbor(AdjacencyMatrix AM, int u) {
        System.out.print("Enumerate neighbors of a vertex " + u + ": ");
        for(int i = 0; i < AM.getVertice(); i++) {
            if(AM.getEdge((u-1), i) == 1) {
                System.out.print((i+1) + " ");
            }
        }
        System.out.println();
    }

    // Check the existence of edge (u, v).
    public static boolean checkExist(AdjacencyMatrix AM, int u, int v) {
        if(AM.getEdge((u-1), (v-1)) == 0) {
            return false;
        } 
        return true;
    }

    // Main
    public static void main(String[] args) {
        AdjacencyMatrix AM = readFile("Input1.txt");
        print(AM);
        System.out.println("Number of vertice: " + countVertice(AM));
        System.out.println("Number of edge: " + countEdge(AM));
        getNeighbor(AM, 3);
        System.out.println("Check the existence of edge (3, 2): " + checkExist(AM, 3, 2));
    }
}