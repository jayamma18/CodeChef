import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> printGraph(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        // Initialize an empty list for every vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Populate the adjacency list for each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            // Since the graph is undirected, add connections both ways
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
}
