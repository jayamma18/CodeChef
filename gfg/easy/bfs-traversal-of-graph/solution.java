import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        int V = adj.size(); // Total number of vertices
        boolean[] visited = new boolean[V];

        // Standard FIFO Queue for tracking elements level-by-level
        Queue<Integer> queue = new LinkedList<>();

        // As per problem description, always start traversal from vertex 0
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            bfsTraversal.add(curr);

            // Traverse neighbors from left to right as they appear in the adjacency list
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return bfsTraversal;
    }
}
