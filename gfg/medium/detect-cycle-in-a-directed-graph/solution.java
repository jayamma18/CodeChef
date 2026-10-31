import java.util.ArrayList;

class Solution {
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Loop through all vertices to handle disconnected graph components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack) {
        // Mark the current node as visited and add to recursion stack
        visited[u] = true;
        recStack[u] = true;

        // Traverse all adjacent neighbors
        for (int v : adj.get(u)) {
            // If neighbor is not visited, recursively check it
            if (!visited[v]) {
                if (dfs(v, adj, visited, recStack)) {
                    return true;
                }
            } 
            // If neighbor is already in the active recursion stack, a cycle exists
            else if (recStack[v]) {
                return true;
            }
        }

        // Remove the vertex from recursion stack before backtracking
        recStack[u] = false;
        return false;
    }
}
