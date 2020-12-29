import java.io.*;

public class Exercise4 {
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

    // Main
    public static void main(String[] args) {
        AdjacencyMatrix AM = readFile("Input1.txt");
        AM.BFS(0);
        AM.DFS(0);
        AM.DFS_Stack(0);
        System.out.println(AM.IsReachable(1, 5));
        AM.convertToAL().printGraph();
    }
}
