import java.util.*;

class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // BFS to find the maximum depth (number of edges from root 1)
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.add(1);
        visited[1] = true;
        
        int maxDepth = -1; // Root node 1 is at edge-depth 0
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int neighbor : adj.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        // Calculate 2^(maxDepth - 1) % (10^9 + 7)
        if (maxDepth == 0) return 0; // Guard rail check
        
        long ans = 1;
        long base = 2;
        int exp = maxDepth - 1;
        long MOD = 1_000_000_007;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        
        return (int) ans;
    }
}
