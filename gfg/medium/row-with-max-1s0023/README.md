# Row with Max 1s in Rowwise Sorted

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a 2D binary array  **arr[][]**  consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.

 **Note:** The array follows 0-based indexing.

 **Examples:** 

```
Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1]]
Output: 2
Explanation: Row 2 contains the most number of 1s (4 - 1s). Hence, the output is 2.
```

```
Input: arr[][] = [[0,0], [1,1]]
Output: 1
Explanation: Row 1 contains the most number of 1s (2 - 1s). Hence, the output is 1.
```

```
Input: arr[][] = [[0,0], [0,0]]
Output: -1
Explanation: No row contains any 1s, so the output is -1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:54:09.419Z  

```java
class Solution {
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        if (n == 0) return -1;
        int m = arr[0].length;

        int r = 0;
        int c = m - 1; // Start at top-right corner
        int maxRowIndex = -1;

        while (r < n && c >= 0) {
            // If the element is 1, move left to find more 1s
            if (arr[r][c] == 1) {
                maxRowIndex = r; // Update the row index with max 1s
                c--;
            } 
            // If the element is 0, move down to check the next row
            else {
                r++;
            }
        }

        return maxRowIndex;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1)