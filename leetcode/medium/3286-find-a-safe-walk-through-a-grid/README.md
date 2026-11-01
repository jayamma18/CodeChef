# Find a Safe Walk Through a Grid

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` binary matrix `grid` and an integer `health`.

You start on the upper-left corner `(0, 0)` and would like to get to the lower-right corner `(m - 1, n - 1)`.

You can move up, down, left, or right from one cell to another adjacent cell as long as your health  *remains*   **positive**.

Cells `(i, j)` with `grid[i][j] = 1` are considered  **unsafe**  and reduce your health by 1.

Return `true` if you can reach the final cell with a health value of 1 or more, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1

 **Output:**  true

 **Explanation:** 

The final cell can be reached safely by walking along the gray cells below.

 **Example 2:** 

 **Input:**  grid = [[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]], health = 3

 **Output:**  false

 **Explanation:** 

A minimum of 4 health points is needed to reach the final cell safely.

 **Example 3:** 

 **Input:**  grid = [[1,1,1],[1,0,1],[1,1,1]], health = 5

 **Output:**  true

 **Explanation:** 

The final cell can be reached safely by walking along the gray cells below.

Any path that does not go through the cell `(1, 1)` is unsafe since your health will drop to 0 when reaching the final cell.

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 50
- 2 <= m * n
- 1 <= health <= m + n
- grid[i][j] is either 0 or 1.

## Solution

**Language:** Java  
**Runtime:** 10 ms (beats 83.07%)  
**Memory:** 46.3 MB (beats 95.90%)  
**Submitted:** 2026-11-01T11:41:49.064Z  

```java
import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // Track the minimum health lost to reach each cell
        int[][] minHealthLost = new int[m][n];
        for (int[] row : minHealthLost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Deque for 0-1 BFS
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        // Base initialization at (0,0)
        minHealthLost[0][0] = grid.get(0).get(0);
        deque.offerFirst(new int[]{0, 0});
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];
            
            // Early exit if we reached the end
            if (r == m - 1 && c == n - 1) {
                break;
            }
            
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int weight = grid.get(nr).get(nc);
                    int nextCost = minHealthLost[r][c] + weight;
                    
                    // If we found a path with fewer health points lost
                    if (nextCost < minHealthLost[nr][nc]) {
                        minHealthLost[nr][nc] = nextCost;
                        
                        // 0-1 BFS optimization
                        if (weight == 0) {
                            deque.offerFirst(new int[]{nr, nc}); // Processing 0-weight paths first
                        } else {
                            deque.offerLast(new int[]{nr, nc});  // 1-weight paths appended to back
                        }
                    }
                }
            }
        }
        
        // To survive, the final health must be >= 1
        int finalHealthLost = minHealthLost[m - 1][n - 1];
        return health - finalHealthLost >= 1;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/find-a-safe-walk-through-a-grid/)