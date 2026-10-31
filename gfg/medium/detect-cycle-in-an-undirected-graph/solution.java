import java.util.*;

class Solution {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, -1});
                visited[i] = true;

                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    int node = curr[0];
                    int parent = curr[1];

                    for (int neighbor : adj.get(node)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            q.add(new int[]{neighbor, node});
                        } else if (neighbor != parent) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}