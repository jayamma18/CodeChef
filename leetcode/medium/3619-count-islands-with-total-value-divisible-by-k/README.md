# Count Islands With Total Value Divisible by K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` matrix `grid` and a positive integer `k`. An  **island**  is a group of  **positive**  integers (representing land) that are  **4-directionally**  connected (horizontally or vertically).

The  **total value**  of an island is the sum of the values of all cells in the island.

Return the number of islands with a total value  **divisible by**  `k`.

 

 **Example 1:** 

 **Input:**  grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5

 **Output:**  2

 **Explanation:** 

The grid contains four islands. The islands highlighted in blue have a total value that is divisible by 5, while the islands highlighted in red do not.

 **Example 2:** 

 **Input:**  grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3

 **Output:**  6

 **Explanation:** 

The grid contains six islands, each with a total value that is divisible by 3.

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 1000
- 1 <= m * n <= 105
- 0 <= grid[i][j] <= 106
- 1 <= k <= 106

## Solution

**Language:** Java  
**Runtime:** 22 ms (beats 64.13%)  
**Memory:** 102.2 MB (beats 93.86%)  
**Submitted:** 2026-11-01T11:49:41.105Z  

```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;
        
        // Direction vectors for moving up, down, left, and right
        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, -1, 1};
        
        // Traverse the entire grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we encounter an unvisited land cell (> 0)
                if (grid[i][j] > 0) {
                    long islandTotalValue = 0;
                    
                    // Queue for BFS traversal
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    
                    // Accumulate current cell value and sink it immediately to mark as visited
                    islandTotalValue += grid[i][j];
                    grid[i][j] = 0; 
                    
                    while (!queue.isEmpty()) {
                        int[] currentCell = queue.poll();
                        int currRow = currentCell[0];
                        int currCol = currentCell[1];
                        
                        // Check all 4-directional neighbors
                        for (int d = 0; d < 4; d++) {
                            int nextRow = currRow + rowOffsets[d];
                            int nextCol = currCol + colOffsets[d];
                            
                            // Validate grid boundaries and look for land properties
                            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] > 0) {
                                islandTotalValue += grid[nextRow][nextCol];
                                grid[nextRow][nextCol] = 0; // Mark cell as visited by sinking it
                                queue.offer(new int[]{nextRow, nextCol});
                            }
                        }
                    }
                    
                    // If the total accumulated island value matches the divisibility rule
                    if (islandTotalValue % k == 0) {
                        islandCount++;
                    }
                }
            }
        }
        
        return islandCount;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/)