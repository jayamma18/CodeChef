# Twisted Mirror Path Count

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` binary grid `grid` where:

- grid[i][j] == 0 represents an empty cell, and
- grid[i][j] == 1 represents a mirror.

A robot starts at the top-left corner of the grid `(0, 0)` and wants to reach the bottom-right corner `(m - 1, n - 1)`. It can move only  **right**  or  **down**. If the robot attempts to move into a mirror cell, it is  **reflected**  before entering that cell:

- If it tries to move right into a mirror, it is turned down and moved into the cell directly below the mirror.
- If it tries to move down into a mirror, it is turned right and moved into the cell directly to the right of the mirror.

If this reflection would cause the robot to move outside the `grid` boundaries, the path is considered invalid and should not be counted.

Return the number of unique valid paths from `(0, 0)` to `(m - 1, n - 1)`.

Since the answer may be very large, return it  **modulo**  `109 + 7`.

 **Note** : If a reflection moves the robot into a mirror cell, the robot is immediately reflected again based on the direction it used to enter that mirror: if it entered while moving right, it will be turned down; if it entered while moving down, it will be turned right. This process will continue until either the last cell is reached, the robot moves out of bounds or the robot moves to a non-mirror cell.

 

 **Example 1:** 

 **Input:**  grid = [[0,1,0],[0,0,1],[1,0,0]]

 **Output:**  5

 **Explanation:** 

Number	Full Path
1	(0, 0) → (0, 1) [M] → (1, 1) → (1, 2) [M] → (2, 2)
2	(0, 0) → (0, 1) [M] → (1, 1) → (2, 1) → (2, 2)
3	(0, 0) → (1, 0) → (1, 1) → (1, 2) [M] → (2, 2)
4	(0, 0) → (1, 0) → (1, 1) → (2, 1) → (2, 2)
5	(0, 0) → (1, 0) → (2, 0) [M] → (2, 1) → (2, 2)
- [M] indicates the robot attempted to enter a mirror cell and instead reflected.

 **Example 2:** 

 **Input:**  grid = [[0,0],[0,0]]

 **Output:**  2

 **Explanation:** 

Number	Full Path
1	(0, 0) → (0, 1) → (1, 1)
2	(0, 0) → (1, 0) → (1, 1)

 **Example 3:** 

 **Input:**  grid = [[0,1,1],[1,1,0]]

 **Output:**  1

 **Explanation:** 

Number	Full Path
1	(0, 0) → (0, 1) [M] → (1, 1) [M] → (1, 2)
`(0, 0) → (1, 0) [M] → (1, 1) [M] → (2, 1)` goes out of bounds, so it is invalid.

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 2 <= m, n <= 500
- grid[i][j] is either 0 or 1.
- grid[0][0] == grid[m - 1][n - 1] == 0

## Solution

**Language:** Java  
**Runtime:** 202 ms (beats 27.87%)  
**Memory:** 284.9 MB (beats 8.20%)  
**Submitted:** 2026-11-01T12:08:56.072Z  

```java
class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dest[r][c][d] stores the packed integer coordinates (row * 1000 + col) 
        // of the final empty cell reached when entering (r, c) with direction d.
        // d = 0 means moving Right, d = 1 means moving Down.
        // A value of -1 indicates the path goes out of bounds.
        int[][][] dest = new int[m][n][2];
        
        // Step 1: Precompute the landing cell for all paths from bottom-right to top-left
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                // Direction 0: Entering (r, c) moving Right
                if (grid[r][c] == 0) {
                    dest[r][c][0] = r * 1000 + c;
                } else {
                    dest[r][c][0] = (r + 1 < m) ? dest[r + 1][c][1] : -1;
                }

                // Direction 1: Entering (r, c) moving Down
                if (grid[r][c] == 0) {
                    dest[r][c][1] = r * 1000 + c;
                } else {
                    dest[r][c][1] = (c + 1 < n) ? dest[r][c + 1][0] : -1;
                }
            }
        }

        // Step 2: Standard Grid DP to count paths
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1; // Base case: 1 way to be at the destination

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1 || (i == m - 1 && j == n - 1)) {
                    continue; // Skip mirrors and the destination cell
                }

                long totalPaths = 0;

                // Option 1: Move Right from empty cell (i, j) -> Enters (i, j+1) moving Right
                if (j + 1 < n) {
                    int landingPoint = dest[i][j + 1][0];
                    if (landingPoint != -1) {
                        totalPaths += dp[landingPoint / 1000][landingPoint % 1000];
                    }
                }

                // Option 2: Move Down from empty cell (i, j) -> Enters (i+1, j) moving Down
                if (i + 1 < m) {
                    int landingPoint = dest[i + 1][j][1];
                    if (landingPoint != -1) {
                        totalPaths += dp[landingPoint / 1000][landingPoint % 1000];
                    }
                }

                dp[i][j] = (int) (totalPaths % MOD);
            }
        }

        return dp[0][0];
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/twisted-mirror-path-count/)