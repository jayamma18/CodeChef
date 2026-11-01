import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // 1. Build adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponentCount = 0;

        // 2. Iterate through each node to find all independent components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] stats = new int[2]; // stats[0] = vertex count, stats[1] = total degree sum
                
                dfs(i, adj, visited, stats);

                int vCount = stats[0];
                int edgeSumCount = stats[1];

                // A component is complete if the degree sum equals V * (V - 1)
                if (edgeSumCount == (long) vCount * (vCount - 1)) {
                    completeComponentCount++;
                }
            }
        }

        return completeComponentCount;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] stats) {
        visited[node] = true;
        stats[0]++; // Increment vertex count
        stats[1] += adj.get(node).size(); // Accumulate the degree of this node

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stats);
            }
        }
    }
}
