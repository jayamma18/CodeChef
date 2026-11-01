import java.util.*;

class Solution {
    private int[] depth;
    private int[][] up;
    private int LOG;
    private long[] pow2;
    private static final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        LOG = (int) (Math.log(n) / Math.log(2)) + 1;
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        depth = new int[n + 1];
        up = new int[n + 1][LOG];
        
        // Precompute powers of 2 modulo 10^9 + 7
        pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        // Run DFS from root (node 1) to build depths and binary lifting tables
        dfs(1, 1, 0, adj);

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            if (u == v) {
                answer[i] = 0;
                continue;
            }

            int lcaNode = getLCA(u, v);
            int pathLength = depth[u] + depth[v] - 2 * depth[lcaNode];
            
            // Result is 2^(pathLength - 1) % MOD
            answer[i] = (int) pow2[pathLength - 1];
        }

        return answer;
    }

    private void dfs(int node, int parent, int d, List<List<Integer>> adj) {
        depth[node] = d;
        up[node][0] = parent;
        for (int i = 1; i < LOG; i++) {
            up[node][i] = up[up[node][i - 1]][i - 1];
        }

        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, d + 1, adj);
            }
        }
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }

        // Lift u to the same depth as v
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = up[u][i];
            }
        }

        if (u == v) return u;

        // Lift both nodes simultaneously right before their common ancestor
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }

        return up[u][0];
    }
}
