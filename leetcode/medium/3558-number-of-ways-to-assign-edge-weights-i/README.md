# Number of Ways to Assign Edge Weights I

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There is an undirected tree with `n` nodes labeled from 1 to `n`, rooted at node 1. The tree is represented by a 2D integer array `edges` of length `n - 1`, where `edges[i] = [ui, vi]` indicates that there is an edge between nodes `ui` and `vi`.

Initially, all edges have a weight of 0. You must assign each edge a weight of either  **1**  or  **2**.

The  **cost**  of a path between any two nodes `u` and `v` is the total weight of all edges in the path connecting them.

Select any one node `x` at the  **maximum**  depth. Return the number of ways to assign edge weights in the path from node 1 to `x` such that its total cost is  **odd**.

Since the answer may be large, return it  **modulo**  `109 + 7`.

 **Note:**  Ignore all edges  **not**  in the path from node 1 to `x`.

 

 **Example 1:** 

 **Input:**  edges = [[1,2]]

 **Output:**  1

 **Explanation:** 

- The path from Node 1 to Node 2 consists of one edge (1 → 2).
- Assigning weight 1 makes the cost odd, while 2 makes it even. Thus, the number of valid assignments is 1.

 **Example 2:** 

 **Input:**  edges = [[1,2],[1,3],[3,4],[3,5]]

 **Output:**  2

 **Explanation:** 

- The maximum depth is 2, with nodes 4 and 5 at the same depth. Either node can be selected for processing.
- For example, the path from Node 1 to Node 4 consists of two edges (1 → 3 and 3 → 4).
- Assigning weights (1,2) or (2,1) results in an odd cost. Thus, the number of valid assignments is 2.

 

 **Constraints:** 

- 2 <= n <= 105
- edges.length == n - 1
- edges[i] == [ui, vi]
- 1 <= ui, vi <= n
- edges represents a valid tree.

## Solution

**Language:** Java  
**Runtime:** 154 ms (beats 15.47%)  
**Memory:** 278.3 MB (beats 83.45%)  
**Submitted:** 2026-11-01T11:12:48.443Z  

```java
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

```

---

[View on LeetCode](https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/)