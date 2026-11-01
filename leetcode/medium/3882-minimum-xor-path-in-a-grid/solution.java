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
