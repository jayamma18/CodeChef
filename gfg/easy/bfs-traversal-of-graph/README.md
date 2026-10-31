# BFS of Graph

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list  **adj[][]**, where each adj[i] represents the list of vertices connected to vertex i.

Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.

 **Note** : Do traverse in the same order as they are in the given adjacency list.

 **Examples:** 

```
Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 3, 1, 4]
Explanation: Starting from 0, the BFS traversal will follow these steps: 
Visit 0 → Output: 0 
Visit 2 (first neighbor of 0) → Output: 0, 2 
Visit 3 (next neighbor of 0) → Output: 0, 2, 3 
Visit 1 (next neighbor of 0) → Output: 0, 2, 3, 1
Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
```

```
Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the BFS traversal proceeds as follows: 
Visit 0 → Output: 0 
Visit 1 (the first neighbor of 0) → Output: 0, 1 
Visit 2 (the next neighbor of 0) → Output: 0, 1, 2 
Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3 
Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
```

**Constraints:
**1 ≤ V = adj.size() ≤ 104
0 ≤ adj[i][j] ≤ 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:04:24.766Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1)