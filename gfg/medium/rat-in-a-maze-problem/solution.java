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
