# Minimum XOR Path in a Grid

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a 2D integer array `grid` of size `m * n`.

You start at the  **top-left**  cell `(0, 0)` and want to reach the  **bottom-right**  cell `(m - 1, n - 1)`.

At each step, you  **may**  move either  **right or down**.

The  **cost**  of a path is defined as the  **bitwise XOR**  of all the values in the cells along that path,  **including**  the start and end cells.

Return the  **minimum**  possible XOR value among all valid paths from `(0, 0)` to `(m - 1, n - 1)`.

 

 **Example 1:** 

 **Input:**  grid = [[1,2],[3,4]]

 **Output:**  6

 **Explanation:** 

There are two valid paths:

- (0, 0) → (0, 1) → (1, 1) with XOR: 1 XOR 2 XOR 4 = 7
- (0, 0) → (1, 0) → (1, 1) with XOR: 1 XOR 3 XOR 4 = 6

The minimum XOR value among all valid paths is 6.

 **Example 2:** 

 **Input:**  grid = [[6,7],[5,8]]

 **Output:**  9

 **Explanation:** 

There are two valid paths:

- (0, 0) → (0, 1) → (1, 1) with XOR: 6 XOR 7 XOR 8 = 9
- (0, 0) → (1, 0) → (1, 1) with XOR: 6 XOR 5 XOR 8 = 11

The minimum XOR value among all valid paths is 9.

 **Example 3:** 

 **Input:**  grid = [[2,7,5]]

 **Output:**  0

 **Explanation:** 

There is only one valid path:

- (0, 0) → (0, 1) → (0, 2) with XOR: 2 XOR 7 XOR 5 = 0

The XOR value of this path is 0, which is the minimum possible.

 

 **Constraints:** 

- 1 <= m == grid.length <= 1000
- 1 <= n == grid[i].length <= 1000
- m * n <= 1000
- 0 <= grid[i][j] <= 1023​

## Solution

**Language:** Java  
**Runtime:** 123 ms (beats 86.10%)  
**Memory:** 47.1 MB (beats 69.08%)  
**Submitted:** 2026-11-01T11:55:18.861Z  

```java
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Maximum possible XOR value is 1023 given constraint grid[i][j] <= 1023
        int MAX_XOR = 1024;
        
        // dp[j][v] tracks whether XOR sum 'v' is reachable at column 'j' for the current row
        boolean[][] dp = new boolean[n][MAX_XOR];
        
        // Initialize the starting position (0,0)
        dp[0][grid[0][0]] = true;
        
        // Fill the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            int val = grid[0][j];
            for (int v = 0; v < MAX_XOR; v++) {
                if (dp[j - 1][v]) {
                    dp[j][v ^ val] = true;
                }
            }
        }
        
        // Process the remaining rows
        for (int i = 1; i < m; i++) {
            boolean[][] nextDp = new boolean[n][MAX_XOR];
            
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                
                // 1. Transition from the cell directly above (dp[j])
                for (int v = 0; v < MAX_XOR; v++) {
                    if (dp[j][v]) {
                        nextDp[j][v ^ val] = true;
                    }
                }
                
                // 2. Transition from the cell to the left (nextDp[j-1])
                if (j > 0) {
                    for (int v = 0; v < MAX_XOR; v++) {
                        if (nextDp[j - 1][v]) {
                            nextDp[j][v ^ val] = true;
                        }
                    }
                }
            }
            dp = nextDp; // Move to the next row layer
        }
        
        // Find the minimum achievable XOR value at the bottom-right cell (n - 1)
        for (int v = 0; v < MAX_XOR; v++) {
            if (dp[n - 1][v]) {
                return v;
            }
        }
        
        return -1;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/minimum-xor-path-in-a-grid/)