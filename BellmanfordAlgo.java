import java.util.Scanner;

public class BellmanfordAlgo {

    // Function to implement Bellman-Ford Algorithm
    public static void bellmanFord(int V, int E, int[][] edges, int src) {
        int[] dist = new int[V];

        // Step 1: Initialize distances from src to all other vertices as INFINITE
        for (int i = 0; i < V; i++) 
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Step 2: Relax all edges V-1 times
        for (int i = 1; i < V; i++) 
        {
            for (int j = 0; j < E; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
                {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        for (int j = 0; j < E; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int weight = edges[j][2];

            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print the shortest distances
        printSolution(dist, V);
    }

    // Utility function to print the shortest distance from the source
    public static void printSolution(int[] dist, int V) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " \t\t INF");
            } else {
                System.out.println(i + " \t\t " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        // Create an array to store the edges
        int[][] edges = new int[E][3];

        // Input edges (source, destination, weight)
        System.out.println("Enter the edges (source, destination, weight):");
        for (int i = 0; i < E; i++) {
            System.out.print("Edge " + (i + 1) + ": ");
            edges[i][0] = sc.nextInt(); // source vertex
            edges[i][1] = sc.nextInt(); // destination vertex
            edges[i][2] = sc.nextInt(); // weight
        }

        // Input the source vertex
        System.out.print("Enter the source vertex: ");
        int source = sc.nextInt();

        // Call the Bellman-Ford algorithm
        bellmanFord(V, E, edges, source);

        sc.close();
    }
}
