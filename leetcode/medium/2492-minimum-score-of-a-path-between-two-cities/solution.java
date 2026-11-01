import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        // Step 1: Build the adjacency list graph
        // Each node maps to a list of pairs: [neighbor_city, road_distance]
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            graph[u].add(new int[]{v, dist});
            graph[v].add(new int[]{u, dist}); // Bidirectional roads
        }

        // Step 2: Traverse the connected component starting from city 1
        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int[] neighbor : graph[curr]) {
                int nextCity = neighbor[0];
                int roadDistance = neighbor[1];

                // Capture the minimum road seen anywhere in this component
                minScore = Math.min(minScore, roadDistance);

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }

        return minScore;
    }
}
