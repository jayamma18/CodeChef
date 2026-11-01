import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        
        // Step 1: Initialize the entire grid as obstacles
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }
        
        // Step 2: Carve out exactly one valid path
        int currRow = 0;
        int currCol = 0;
        grid[currRow][currCol] = '.';
        
        while (currRow < m - 1 || currCol < n - 1) {
            // Move right if we haven't reached the last column yet
            if (currCol < n - 1) {
                currCol++;
            } 
            // Otherwise, move down along the rightmost boundary wall
            else {
                currRow++;
            }
            grid[currRow][currCol] = '.';
        }
        
        // Step 3: Convert the character matrix into an array of Strings
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }
}
