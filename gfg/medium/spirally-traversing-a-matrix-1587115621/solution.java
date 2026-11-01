import java.util.ArrayList;

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> result = new ArrayList<>();

        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return result;
        }

        int n = mat.length;
        int m = mat[0].length;

        // Initialize boundaries
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++; // Move the top boundary down

            // 2. Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--; // Move the right boundary left

            // 3. Traverse from right to left along the bottom row (if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // 4. Traverse from bottom to top along the left column (if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++; // Move the left boundary right
            }
        }

        return result;
    }
}
