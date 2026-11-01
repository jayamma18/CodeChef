import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        // dp arrays to store maximum scores and their respective path counts
        int[][] maxScore = new int[n][n];
        int[][] paths = new int[n][n];

        // Initialize score table with -1 (representing unreachable cells)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxScore[i][j] = -1;
            }
        }

        // Base case: Start at the bottom-right corner
        maxScore[n - 1][n - 1] = 0;
        paths[n - 1][n - 1] = 1;

        // Directions to check: down, right, and down-right diagonal
        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

        // Process the board backwards from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Skip the starting point initialization logic and obstacles
                if ((i == n - 1 && j == n - 1) || board.get(i).charAt(j) == 'X') {
                    continue;
                }

                int currentCellVal = 0;
                char c = board.get(i).charAt(j);
                if (c >= '1' && c <= '9') {
                    currentCellVal = c - '0';
                }

                int bestPrevScore = -1;
                int currentPaths = 0;

                // Look at the 3 valid incoming cells
                for (int[] dir : dirs) {
                    int prevI = i + dir[0];
                    int prevJ = j + dir[1];

                    // Check boundaries and check if the previous cell was reachable
                    if (prevI < n && prevJ < n && maxScore[prevI][prevJ] != -1) {
                        if (maxScore[prevI][prevJ] > bestPrevScore) {
                            bestPrevScore = maxScore[prevI][prevJ];
                            currentPaths = paths[prevI][prevJ];
                        } else if (maxScore[prevI][prevJ] == bestPrevScore) {
                            currentPaths = (currentPaths + paths[prevI][prevJ]) % MOD;
                        }
                    }
                }

                // If at least one valid previous step exists, update current cell's DP state
                if (bestPrevScore != -1) {
                    maxScore[i][j] = bestPrevScore + currentCellVal;
                    paths[i][j] = currentPaths;
                }
            }
        }

        // Return result from the destination cell 'E' at (0, 0)
        if (maxScore[0][0] == -1) {
            return new int[]{0, 0};
        }
        return new int[]{maxScore[0][0], paths[0][0]};
    }
}
