# Graph Adjacency List Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an undirected graph with  **V** nodes and  **E**  edges, create and return an adjacency list of the graph. 0-based indexing is followed everywhere.

 **Example 1:** 

```
Input:
V = 5, E = 7
edges = [[0,1], [0,4], [4,1], [4,3], [1,3], [1,2], [3,2]]

Output: 
[[1,4], [0,2,3,4], [1,3], [1,2,4], [0,1,3]]
Explanation:
Node 0 is connected to 1 and 4.
Node 1 is connected to 0,2,3 and 4.
Node 2 is connected to 1 and 3.
Node 3 is connected to 1,2 and 4.
Node 4 is connected to 0,1 and 3.

```

 **Example 2:** 

```
Input:
V = 4, E = 3
edges = [[0,3], [0,2], [2,1]]
  
Output: 
[[2,3], [2], [0,1], [0]]
Explanation:
Node 0 is connected to 2 and 3.
Node 1 is only connected to 2.
Node 2 is connected to 0 and 1.
Node 3 is only connected to 0.
```

 **Constraints:** 
1 ≤ V, E ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T13:02:50.162Z  

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> printGraph(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        // Initialize an empty list for every vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Populate the adjacency list for each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            // Since the graph is undirected, add connections both ways
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1)