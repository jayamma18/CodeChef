# Count Subsets with Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of non-negative integers and an integer  **target**, the task is to count all subsets of the array whose sum is equal to the given target.

 **Examples:** 

```
Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
Output: 3
Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.
```

```
Input: arr[] = [2, 5, 1, 4, 3], target = 10
Output: 3
Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.
```

```
Input: arr[] = [5, 7, 8], target = 3
Output: 0
Explanation: There are no subsets of the array that sum up to the target 3.
```

```
Input: arr[] = [35, 2, 8, 22], target = 0
Output: 1
Explanation: The empty subset is the only subset with a sum of 0.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:31:03.615Z  

```java
class Solution {
    static int perfectSum(int[] arr, int target) {
        int mod = 1000000007;
        int[] dp = new int[target + 1];

        // Base case: There is 1 way to form a sum of 0 (using an empty subset)
        dp[0] = 1;

        // Process each number in the array
        for (int num : arr) {
            // Traverse backward to ensure we use each element at most once (0/1 Knapsack style)
            for (int j = target; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % mod;
            }
        }

        return dp[target];
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1)