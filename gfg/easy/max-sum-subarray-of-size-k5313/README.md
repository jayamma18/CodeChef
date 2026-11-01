# Max Sum Subarray of Size K

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of integers **arr[]**  and a number **k**. Return the maximum sum of a subarray of size k.

 **Note:**  A subarray is a contiguous part of any given array.

 **Examples:** 

```
Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.
```

```
Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.

```

```
Input: arr[] = [100, 200, 300, 400], k = 1
Output: 400
Explanation: arr3 = 400, which is maximum.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T13:03:11.902Z  

```java
class Solution {
    // GeeksforGeeks driver code expects an int return type
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        long currentWindowSum = 0;

        // Step 1: Compute the sum of the first window of size k
        for (int i = 0; i < k; i++) {
            currentWindowSum += arr[i];
        }

        long maxSum = currentWindowSum;

        // Step 2: Slide the window from index k to the end of the array
        for (int i = k; i < n; i++) {
            // Add the new element entering the window and subtract the one leaving it
            currentWindowSum += arr[i] - arr[i - k];

            // Track the maximum sum found so far
            maxSum = Math.max(maxSum, currentWindowSum);
        }

        // Cast the final result back to int to match the expected return type
        return (int) maxSum;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)