# Number of Paths with Max Score

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a square `board` of characters. You can move on the board starting at the bottom right square marked with the character `'S'`.

You need to reach the top left square marked with the character `'E'`. The rest of the squares are labeled either with a numeric character `1, 2,..., 9` or with an obstacle `'X'`. In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.

Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect, and the second is the number of such paths that you can take to get that maximum sum,  **taken modulo `10^9 + 7`**.

In case there is no path, return `[0, 0]`.

 

 **Example 1:** 

```
Input: board = ["E23","2X2","12S"]
Output: [7,1]

```

 **Example 2:** 

```
Input: board = ["E12","1X1","21S"]
Output: [4,2]

```

 **Example 3:** 

```
Input: board = ["E11","XXX","11S"]
Output: [0,0]

```

 

 **Constraints:** 

- 2 <= board.length == board[i].length <= 100

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 89.73%)  
**Memory:** 44.1 MB (beats 93.16%)  
**Submitted:** 2026-11-01T11:46:00.815Z  

```java
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

```

---

[View on LeetCode](https://leetcode.com/problems/number-of-paths-with-max-score/)