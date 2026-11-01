# Check if There Is a Valid Parentheses String Path

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

A parentheses string is a  **non-empty**  string consisting only of `'('` and `')'`. It is  **valid**  if  **any**  of the following conditions is  **true** :

- It is ().
- It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
- It can be written as (A), where A is a valid parentheses string.

You are given an `m x n` matrix of parentheses `grid`. A  **valid parentheses string path**  in the grid is a path satisfying  **all**  of the following conditions:

- The path starts from the upper left cell (0, 0).
- The path ends at the bottom-right cell (m - 1, n - 1).
- The path only ever moves down or right.
- The resulting parentheses string formed by the path is valid.

Return `true`  *if there exists a  **valid parentheses string path**  in the grid.*  Otherwise, return `false`.

 

 **Example 1:** 

```
Input: grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
Output: true
Explanation: The above diagram shows two possible paths that form valid parentheses strings.
The first path shown results in the valid parentheses string "()(())".
The second path shown results in the valid parentheses string "((()))".
Note that there may be other valid parentheses string paths.

```

 **Example 2:** 

```
Input: grid = [[")",")"],["(","("]]
Output: false
Explanation: The two possible paths form the parentheses strings "))(" and ")((". Since neither of them are valid parentheses strings, we return false.

```

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 100
- grid[i][j] is either '(' or ')'.

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 78.74%)  
**Memory:** 74.4 MB (beats 41.57%)  
**Submitted:** 2026-11-01T11:09:34.778Z  

```java
class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // A valid parentheses string must have an even length.
        // Total steps taken = m + n - 1
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
        // The maximum possible balance we can ever achieve is (m + n) / 2
        int maxBalance = (m + n) / 2;
        
        // memo[r][c][bal] will store whether a valid path exists from (r, c) with current balance 'bal'
        // Using Boolean instead of boolean to utilize null for unvisited states
        Boolean[][][] memo = new Boolean[m][n][maxBalance + 1];
        
        return dfs(0, 0, 0, grid, memo);
    }
    
    private boolean dfs(int r, int c, int bal, char[][] grid, Boolean[][][] memo) {
        // Adjust balance based on the current cell
        if (grid[r][c] == '(') {
            bal++;
        } else {
            bal--;
        }
        
        // Invalid state checks:
        // 1. Balance drops below 0 (more ')' than '(')
        // 2. Balance exceeds the maximum possible useful balance
        if (bal < 0 || bal >= memo[0][0].length) {
            return false;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        // Base case: Reached the bottom-right cell
        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }
        
        // Return cached result if already calculated
        if (memo[r][c][bal] != null) {
            return memo[r][c][bal];
        }
        
        boolean foundPath = false;
        
        // Move Down
        if (r + 1 < m) {
            foundPath = foundPath || dfs(r + 1, c, bal, grid, memo);
        }
        
        // Move Right
        if (c + 1 < n) {
            foundPath = foundPath || dfs(r, c + 1, bal, grid, memo);
        }
        
        // Cache and return the result
        return memo[r][c][bal] = foundPath;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/)