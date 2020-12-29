import java.io.*;

public class MST {

    // Read File 
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

    // Prim Algorithm
    public static void primAlgorithm(AdjacencyMatrix AM) {
        boolean[] visited = new boolean[AM.getVertice()];   // Đánh dấu những đỉnh đã xét 
        int[] parent = new int[AM.getVertice()];    // Lưu những đỉnh đã xét 
        int[] cost = new int[AM.getVertice()];  // Lưu trọng số 

        // Cài đặt visited[], tất cả các phần tử đều là false 
        for(int i = 0; i < AM.getVertice(); i++) {
            visited[i] = false;
            cost[i] = Integer.MAX_VALUE;
        } 

        // Xét từ phần tử 0 
        cost[0] = 0;
        parent[0] = -1;

        // Thực hiện 
        for(int c = 0; c < AM.getVertice() - 1; c++) {
            int min = Integer.MAX_VALUE, min_index = -1;

            // Tìm đỉnh có trọng số nhỏ nhất
            for(int v = 0; v < AM.getVertice(); v++) {
                if(!visited[v] && cost[v] < min) {
                    min = cost[v];
                    min_index = v;
                }
            }
            int u = min_index;
            visited[u] = true;
            for(int v = 0; v < AM.getVertice(); v++) {
                if(AM.getEdge(u, v) != 0 && !visited[v] &&  AM.getEdge(u, v) < cost[v]) {
                    parent[v] = u;
                    cost[v] = AM.getEdge(u, v);
                }
            }
        }
        // Tính trọng các trọng số 
        int total = 0;
        for(int i = 0; i < AM.getVertice(); i++) {
            total += cost[i];
        }

        // In kết quả 
        System.out.println("\n ***** Prim Algorithm *****\n");
        System.out.println(" u - v\tweight");
        System.out.println(" -------------");
        for(int i = 1; i < AM.getVertice(); i++) {
           System.out.println(" " + parent[i] + " - " + i + "\t" + cost[i]);
        }
        System.out.println(" => MST = " + total);
    }

    // Kruskal Algorithm
    public static void kruskalAlgorithm(AdjacencyMatrix AM) {
        EdgeList EL = new EdgeList();   // Lưu các cạnh đã sắp xếp thứ tự tăng dần của trọng số 
        EdgeList mst = new EdgeList();  // Lưu kết quả các cạnh 
        boolean[][] visited = new boolean[AM.getNumberOfEdge()][AM.getNumberOfEdge()];  // Đánh dấu những cạnh đã xét 
        UnionFind UF = new UnionFind(AM.getVertice());  // Kiểm tra chu trình 
        
        // Cài đặt visited[] 
        for(int i = 0; i < AM.getVertice(); i++) {
            for(int j = 0; j < AM.getVertice(); j++) {
                if(AM.getEdge(i, j) != 0) {
                    visited[i][j] = false;
                    visited[j][i] = false;
                }
            }
        }

        // Sắp xếp các cạnh của AM theo thứ tự tăng dần của trọng số, sau đó thêm vào EL
        for(int i = 0; i < AM.getNumberOfEdge(); i++) {
            int min = Integer.MAX_VALUE, u = 0, v = 0;
            for(int countU = 0; countU < AM.getVertice(); countU++) {
                for(int countV = 0; countV < AM.getVertice(); countV++) {
                    if(!visited[countU][countV] && AM.getEdge(countU, countV) != 0 && AM.getEdge(countU, countV) < min) {
                        min = AM.getEdge(countU, countV);
                        u = countU;
                        v = countV;
                    }
                }
            }

            // Thêm cạnh vào EL, đặt lại visited[] 
            EL.addEdge(u, v, min);
            visited[u][v] = true;
            visited[v][u] = true;
        }
        
        // Kiểm tra cạnh thêm vào có tạo thành chu trình hay không, nếu không thì thêm cạnh đó vào mst 
        for(int i = 0; i < EL.getSize(); i++) {
            IntegerTriple edge = EL.getEdgeEle(i);
            if(UF.isSameSet(EL.getEdgeEle(i).getSource(), EL.getEdgeEle(i).getDest())) {
                continue;
            } else {
                mst.addEdge(edge);
                UF.unionSet(EL.getEdgeEle(i).getSource(), EL.getEdgeEle(i).getDest());
            }
        }

        // Tính tổng trọng số MST
        int total = 0;
        for(int i = 0; i < mst.getSize(); i++) {
            total += mst.getEdgeEle(i).getWeight();
        }

        // In kết quả 
        System.out.println("\n ***** Kruskal Algorithm *****\n");
        mst.printGraph();
        System.out.println(" => MST = " + total);
    }

    public static void main(String[] args) {
        AdjacencyMatrix AM = readFile("Input1.txt");
        primAlgorithm(AM);
        kruskalAlgorithm(AM);
    }
}
