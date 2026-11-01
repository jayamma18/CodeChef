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
