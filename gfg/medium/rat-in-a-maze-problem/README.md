# Rat in Maze

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a binary matrix  **maze[][]**  of size **n × n**  containing values  **0**  and  **1**, find all possible paths for a rat to travel from the source cell (0, 0) to the destination cell (n - 1, n - 1). The rat can move in four directions: up(U), down(D), left(L), and right(R).

- 1 represents an open cell through which the rat can move.
- 0 represents a blocked cell that cannot be traversed.

The rat can move only through open cells and cannot visit the same cell more than once in a path. Return all valid paths as strings consisting of 'U', 'D', 'L', and 'R', representing the sequence of moves taken by the rat.

 **Note:**  Return the paths in lexicographically increasing order. If no valid path exists, return an empty list.

 **Examples:** 

```
Input: maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}
Output: ["DDRDRR", "DRDDRR"]
Explanation: There are two valid paths from the source cell (0, 0) to the destination cell (3, 3).

```

```
Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell (1, 1) is blocked.

```

 **Constraints:** 
2 ≤ n ≤ 5
0 ≤ maze[i][j] ≤ 1

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:10:43.873Z  

```java
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;

        // Check base cases: empty maze or start/end is blocked
        if (n == 0 || maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }

        // Visited array to keep track of the cell paths
        boolean[][] visited = new boolean[n][n];

        // Start backtracking from (0,0) with an empty path string
        solve(0, 0, maze, n, ans, "", visited);

        return ans;
    }

    private void solve(int r, int c, int[][] maze, int n, ArrayList<String> ans, String path, boolean[][] visited) {
        // Base case: destination reached
        if (r == n - 1 && c == n - 1) {
            ans.add(path);
            return;
        }

        // Mark the current cell as visited
        visited[r][c] = true;

        // 1. Move Down ('D')
        if (isValid(r + 1, c, maze, n, visited)) {
            solve(r + 1, c, maze, n, ans, path + "D", visited);
        }

        // 2. Move Left ('L')
        if (isValid(r, c - 1, maze, n, visited)) {
            solve(r, c - 1, maze, n, ans, path + "L", visited);
        }

        // 3. Move Right ('R')
        if (isValid(r, c + 1, maze, n, visited)) {
            solve(r, c + 1, maze, n, ans, path + "R", visited);
        }

        // 4. Move Up ('U')
        if (isValid(r - 1, c, maze, n, visited)) {
            solve(r - 1, c, maze, n, ans, path + "U", visited);
        }

        // Backtrack: unmark the current cell
        visited[r][c] = false;
    }

    private boolean isValid(int r, int c, int[][] maze, int n, boolean[][] visited) {
        return (r >= 0 && r < n && c >= 0 && c < n && maze[r][c] == 1 && !visited[r][c]);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1)