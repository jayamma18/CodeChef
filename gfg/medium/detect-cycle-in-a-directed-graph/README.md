# Directed Graph Cycle

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a directed graph with  **V**  vertices, numbered from 0 to V - 1, represented by an adjacency list  **adj[][]**, where adj[u] contains all vertices reachable from vertex u through a directed edge, check whether the graph contains a cycle.

 **Note:** The graph may have multiple connected components. Self-loops are allowed, but repeated edges are not allowed.

 **Examples:** 

```
Input: adj = [[1], [2], [0, 3], []]

Output: true
Explanation: The diagram clearly shows a cycle 0 -> 1 -> 2 -> 0
```

```
Input: adj = [[1], [2], [3], []]

Output: false
Explanation: The graph does not contain any cycle.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:46:17.262Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)