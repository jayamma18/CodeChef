# Subset Sum Problem

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of positive integers  **arr[]**  and a value  **sum**, find if there is a subset of arr[] with sum equal to given sum. 

 **Examples:** 

```
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

```

```
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
```

```
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:41:53.928Z  

```java
class Solution {
    // Function to check if a subset with the given sum exists
    static Boolean isSubsetSum(int[] arr, int sum) {
        // dp[i] will store whether a sum of 'i' is possible
        boolean[] dp = new boolean[sum + 1];

        // Base case: A sum of 0 is always possible (by picking an empty subset)
        dp[0] = true;

        // Iterate through all items in the array
        for (int num : arr) {
            // Traverse backward to ensure we don't use the same element multiple times
            for (int j = sum; j >= num; j--) {
                // If a sum of (j - num) was possible, then a sum of j is also possible
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }

        return dp[sum];
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1)