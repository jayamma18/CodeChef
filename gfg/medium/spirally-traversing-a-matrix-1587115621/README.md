# Spirally Traversing Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a rectangular matrix  **mat[][]**  of size  **n x m**, and return a 1D array containing all its elements in  **spiral** order.

 **Examples:** 

```
Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
Explanation: 

```

```
Input: mat[][] = [[1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12], [13, 14, 15, 16, 17, 18]]
Output: [1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11]
Explanation: Applying same technique as shown above.
```

```
Input: mat[][] = [[32, 44, 27, 23], [54, 28, 50, 62]]
Output: [32, 44, 27, 23, 62, 50, 28, 54]
Explanation: Applying same technique as shown above, output will be [32, 44, 27, 23, 62, 50, 28, 54].
```

 **Constraints:** 
1 ≤ n, m ≤1000
0 ≤ mat[i][j] ≤100

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:32:45.134Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1)