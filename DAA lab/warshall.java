import java.util.Arrays;

public class WarshallAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, Integer.MAX_VALUE, 1},
            {Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        int[][] transitiveClosure = warshall(graph);

        System.out.println("Transitive Closure:");
        for (int i = 0; i < transitiveClosure.length; i++) {
            for (int j = 0; j < transitiveClosure[i].length; j++) {
                if (transitiveClosure[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(transitiveClosure[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] warshall(int[][] graph) {
        int V = graph.length;
        int[][] transitiveClosure = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                transitiveClosure[i][j] = graph[i][j];
            }
        }

        // Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    
                    if (transitiveClosure[i][k] != Integer.MAX_VALUE && transitiveClosure[k][j] != Integer.MAX_VALUE) {
                        transitiveClosure[i][j] = 1;
                    }
                }
            }
        }

        return transitiveClosure;
    }
}
