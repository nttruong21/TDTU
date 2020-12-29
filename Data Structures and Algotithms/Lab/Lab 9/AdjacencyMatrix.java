import java.util.*;

public class AdjacencyMatrix {

    private int[][] adj;
    private final int NUMBER_OF_VERTICES;

    public AdjacencyMatrix(int vertices) {
        NUMBER_OF_VERTICES = vertices;
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
    }

    public int getVertice() {
        return NUMBER_OF_VERTICES;
    }

    public void setEdge(int vertexSource, int vertexDestination, int weight) {
        try {
            adj[vertexSource][vertexDestination] = weight;
            adj[vertexDestination][vertexSource] = weight;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The vertex is invalid!");
        }
    }

    public int getEdge(int vertexSource, int vertexDestination) {
        try {
            return adj[vertexSource][vertexDestination];
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("The vertex is invalid");
        }
        return -1;
    }

    public void printGraph() {
        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for(int j = 0; j < NUMBER_OF_VERTICES; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        int x;
        while(!queue.isEmpty()) {
            x = queue.poll();
            System.out.print((x+1) + " ");
            for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if(adj[x][i] != 0 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public void DFS_recur(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print((v+1) + " ");
        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if(adj[v][i] != 0 && visited[i] == false) {
                DFS_recur(i, visited);
            }
        }
    }

    public void DFS(int s) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        DFS_recur(s, visited);
        System.out.println();
    }

    public void DFS_Stack(int s) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        stack.push(s);
        visited[s] = true;
        System.out.print((s+1) + " ");
        int temp;
        while(!stack.isEmpty()) {
            temp = stack.pop();
            for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if(adj[temp][i] == 1 && visited[i] == false) {
                    stack.push(i);
                    visited[i] = true;
                    System.out.print((i+1) + " ");
                }
            }
        }
        System.out.println();
    }

    public boolean IsReachable(int v, int u) {
        return adj[u-1][v-1] == 1;
    }

    // Exercise 5
    public AdjacencyList convertToAL() {
        AdjacencyList AL = new AdjacencyList(NUMBER_OF_VERTICES);
        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for(int j = 0; j < NUMBER_OF_VERTICES; j++) {
                if(adj[i][j] == 1) {
                    AL.getAdjEle(i).add(j);
                }
            }
        }
        return AL;
    }
}