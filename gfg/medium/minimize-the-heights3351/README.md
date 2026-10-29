# Minimize the Heights

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  representing the heights of n towers and a positive integer  **k**. For each tower, perform exactly one of the following operations exactly once:

- Increase its height by k, or
- Decrease its height by k.

After performing the operation on every tower, the height of any tower must not become negative.

Return the minimum possible difference between the heights of the tallest and the shortest towers after modifying all the towers.

 **Examples :** 

```
Input: k = 2, arr[] = [1, 5, 8, 10]
Output: 5
Explanation: The array can be modified as [1+k, 5-k, 8-k, 10-k] = [3, 3, 6, 8]. The difference between the largest and the smallest is 8-3 = 5.

```

```
Input: k = 3, arr[] = [3, 9, 12, 16, 20]
Output: 11
Explanation: The array can be modified as [3+k, 9+k, 12-k, 16-k, 20-k] = [6, 12, 9, 13, 17]. The difference between the largest and the smallest is 17-6 = 11. 

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T09:03:22.943Z  

```java
import java.util.Arrays;

class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;

        // If there is only one tower, the difference between largest and smallest is 0
        if (n == 1) return 0;

        // Step 1: Sort the array to organize towers by ascending height
        Arrays.sort(arr);

        // Initial maximum possible difference without any specific split point modification
        int res = arr[n - 1] - arr[0];

        // Step 2: Iterate through possible partition split points
        for (int i = 0; i < n - 1; i++) {
            // Ensure modifying the height down does not create a illegal negative height
            if (arr[i + 1] - k < 0) {
                continue;
            }

            // Potential minimum height after split operations
            int minHeight = Math.min(arr[0] + k, arr[i + 1] - k);

            // Potential maximum height after split operations
            int maxHeight = Math.max(arr[n - 1] - k, arr[i] + k);

            // Update response to keep tracking of the absolute minimal range found
            res = Math.min(res, maxHeight - minHeight);
        }

        return res;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1)