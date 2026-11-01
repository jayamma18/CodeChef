import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        
        // Step 1: Build adjacency list and calculate in-degrees for Topological Sort
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            graph[u].add(new int[]{v, cost});
            inDegree[v]++;
        }

        // Step 2: Compute global topological order once
        int[] topoOrder = new int[n];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            topoOrder[idx++] = u;
            for (int[] edge : graph[u]) {
                int v = edge[0];
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // Step 3: Binary Search for the maximum bottleneck edge cost
        int low = 0, high = 1000000000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(mid, n, topoOrder, graph, online, k)) {
                ans = mid;      // mid is a valid minimum edge cost
                low = mid + 1;  // Try to find a larger minimum edge cost
            } else {
                high = mid - 1; // Lower the threshold
            }
        }

        return ans;
    }

    private boolean isValid(int minCostThreshold, int n, int[] topoOrder, List<int[]>[] graph, boolean[] online, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        // Process nodes in topological order
        for (int u : topoOrder) {
            if (dist[u] == Long.MAX_VALUE) continue;
            if (!online[u] && u != 0) continue; // Skip offline nodes

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int cost = edge[1];

                // Only traverse edges that meet or exceed our binary search threshold
                if (cost >= minCostThreshold && (online[v] || v == n - 1)) {
                    if (dist[u] + cost < dist[v]) {
                        dist[v] = dist[u] + cost;
                    }
                }
            }
        }

        return dist[n - 1] <= k;
    }
}
