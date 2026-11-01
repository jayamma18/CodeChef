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
