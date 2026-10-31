# Undirected Graph Cycle

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an undirected graph with  **V**  vertices, represented by an adjacency list  **adj[][]**, where adj[u] contains all vertices adjacent to vertex u, check whether the graph contains a cycle.

 **Note:**  The graph may have multiple connected components.

 **Examples:** 

```
Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
Output: true
Explanation: 

1 -> 2 -> 0 -> 1 is a cycle.

```

```
Input: adj[][] = [[1], [0, 2], [1, 3], [2]]
Output: false
Explanation: 

No cycle in the graph.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:18:45.396Z  

```java
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)