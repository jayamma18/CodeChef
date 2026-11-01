# Number of Ways to Assign Edge Weights II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

There is an undirected tree with `n` nodes labeled from 1 to `n`, rooted at node 1. The tree is represented by a 2D integer array `edges` of length `n - 1`, where `edges[i] = [ui, vi]` indicates that there is an edge between nodes `ui` and `vi`.

Initially, all edges have a weight of 0. You must assign each edge a weight of either  **1**  or  **2**.

The  **cost**  of a path between any two nodes `u` and `v` is the total weight of all edges in the path connecting them.

You are given a 2D integer array `queries`. For each `queries[i] = [ui, vi]`, determine the number of ways to assign weights to edges  **in the path**  such that the cost of the path between `ui` and `vi` is  **odd**.

Return an array `answer`, where `answer[i]` is the number of valid assignments for `queries[i]`.

Since the answer may be large, apply  **modulo**  `109 + 7` to each `answer[i]`.

 **Note:**  For each query, disregard all edges  **not**  in the path between node `ui` and `vi`.

 

 **Example 1:** 

 **Input:**  edges = [[1,2]], queries = [[1,1],[1,2]]

 **Output:**  [0,1]

 **Explanation:** 

- Query [1,1]: The path from Node 1 to itself consists of no edges, so the cost is 0. Thus, the number of valid assignments is 0.
- Query [1,2]: The path from Node 1 to Node 2 consists of one edge (1 → 2). Assigning weight 1 makes the cost odd, while 2 makes it even. Thus, the number of valid assignments is 1.

 **Example 2:** 

 **Input:**  edges = [[1,2],[1,3],[3,4],[3,5]], queries = [[1,4],[3,4],[2,5]]

 **Output:**  [2,1,4]

 **Explanation:** 

- Query [1,4]: The path from Node 1 to Node 4 consists of two edges (1 → 3 and 3 → 4). Assigning weights (1,2) or (2,1) results in an odd cost. Thus, the number of valid assignments is 2.
- Query [3,4]: The path from Node 3 to Node 4 consists of one edge (3 → 4). Assigning weight 1 makes the cost odd, while 2 makes it even. Thus, the number of valid assignments is 1.
- Query [2,5]: The path from Node 2 to Node 5 consists of three edges (2 → 1, 1 → 3, and 3 → 5). Assigning (1,2,2), (2,1,2), (2,2,1), or (1,1,1) makes the cost odd. Thus, the number of valid assignments is 4.

 

 **Constraints:** 

- 2 <= n <= 105
- edges.length == n - 1
- edges[i] == [ui, vi]
- 1 <= queries.length <= 105
- queries[i] == [ui, vi]
- 1 <= ui, vi <= n
- edges represents a valid tree.

## Solution

**Language:** Java  
**Runtime:** 161 ms (beats 18.01%)  
**Memory:** 297.4 MB (beats 10.90%)  
**Submitted:** 2026-11-01T11:13:32.000Z  

```java
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

```

---

[View on LeetCode](https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/)