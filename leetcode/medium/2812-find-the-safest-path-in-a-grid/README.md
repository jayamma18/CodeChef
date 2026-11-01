# Find the Safest Path in a Grid

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a  **0-indexed**  2D matrix `grid` of size `n x n`, where `(r, c)` represents:

- A cell containing a thief if grid[r][c] = 1
- An empty cell if grid[r][c] = 0

You are initially positioned at cell `(0, 0)`. In one move, you can move to any adjacent cell in the grid, including cells containing thieves.

The  **safeness factor**  of a path on the grid is defined as the  **minimum**  manhattan distance from any cell in the path to any thief in the grid.

Return  *the  **maximum safeness factor**  of all paths leading to cell* `(n - 1, n - 1)` *.* 

An  **adjacent**  cell of cell `(r, c)`, is one of the cells `(r, c + 1)`, `(r, c - 1)`, `(r + 1, c)` and `(r - 1, c)` if it exists.

The  **Manhattan distance**  between two cells `(a, b)` and `(x, y)` is equal to `|a - x| + |b - y|`, where `|val|` denotes the absolute value of val.

 

 **Example 1:** 

```
Input: grid = [[1,0,0],[0,0,0],[0,0,1]]
Output: 0
Explanation: All paths from (0, 0) to (n - 1, n - 1) go through the thieves in cells (0, 0) and (n - 1, n - 1).

```

 **Example 2:** 

```
Input: grid = [[0,0,1],[0,0,0],[0,0,0]]
Output: 2
Explanation: The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 2) is cell (0, 0). The distance between them is | 0 - 0 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.

```

 **Example 3:** 

```
Input: grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
Output: 2
Explanation: The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 3) is cell (1, 2). The distance between them is | 0 - 1 | + | 3 - 2 | = 2.
- The closest cell of the path to the thief at cell (3, 0) is cell (3, 2). The distance between them is | 3 - 3 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.

```

 

 **Constraints:** 

- 1 <= grid.length == n <= 400
- grid[i].length == n
- grid[i][j] is either 0 or 1.
- There is at least one thief in the grid.

## Solution

**Language:** Java  
**Runtime:** 94 ms (beats 90.42%)  
**Memory:** 117.5 MB (beats 74.20%)  
**Submitted:** 2026-11-01T11:40:51.283Z  

```java
import java.util.*;

class Solution {
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // Edge cases where endpoints contain a thief directly
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] distToThief = new int[n][n];
        for (int[] row : distToThief) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> bfsQueue = new LinkedList<>();

        // Phase 1: Initialize Multi-source BFS with all thief coordinates
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    bfsQueue.offer(new int[]{r, c});
                    distToThief[r][c] = 0;
                }
            }
        }

        // Calculate Manhattan distance to the closest thief for all grid elements
        while (!bfsQueue.isEmpty()) {
            int[] curr = bfsQueue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && distToThief[nr][nc] == -1) {
                    distToThief[nr][nc] = distToThief[r][c] + 1;
                    bfsQueue.offer(new int[]{nr, nc});
                }
            }
        }

        // Phase 2: Find path maximizing the minimum safeness factor using a Max-Heap Dijkstra
        // Heap structure: [safeness_factor_so_far, row, col] sorted descendingly by safeness factor
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        boolean[][] visited = new boolean[n][n];

        maxHeap.offer(new int[]{distToThief[0][0], 0, 0});
        visited[0][0] = true;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int maxSafeness = curr[0];
            int r = curr[1];
            int c = curr[2];

            // Reached the destination
            if (r == n - 1 && c == n - 1) {
                return maxSafeness;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // Safeness of a path is governed by its weakest bottleneck link
                    int nextSafeness = Math.min(maxSafeness, distToThief[nr][nc]);
                    maxHeap.offer(new int[]{nextSafeness, nr, nc});
                }
            }
        }

        return 0;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/find-the-safest-path-in-a-grid/)