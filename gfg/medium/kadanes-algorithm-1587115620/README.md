# Kadane's Algorithm

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array  **arr[].**  You need to find the maximum sum of a subarray (containing at least one element) in the array  **arr[]**.

 **Examples:** 

```
Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.

```

```
Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray [-2] has the largest sum -2.
```

```
Input: arr[] = [5, 4, 1, 7, 8]
Output: 25
Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T08:59:09.618Z  

```java
class Solution {
    int maxSubarraySum(int[] arr) {
        // Stores the maximum subarray sum found so far
        int res = arr[0]; 
        
        // Stores the maximum sum of the subarray ending at the current position
        int maxEnding = arr[0]; 
        
        for (int i = 1; i < arr.length; i++) {
            // Either extend the previous subarray or start a new one from the current element
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            
            // Update the overall maximum result if the current subarray sum is larger
            res = Math.max(res, maxEnding);
        }
        
        return res;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1)