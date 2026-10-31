# 0 - 1 Knapsack Problem

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two arrays,  **val[]**  and  **wt[]**, where each element represents the value and weight of an item respectively, and an integer  **W**  representing the maximum capacity of the knapsack (the total weight it can hold).

Put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.

 **Note:** You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.

 **Examples :** 

```
Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
```

```
Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
```

```
Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:40:07.919Z  

```java
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        // dp[w] stores the maximum value achievable with a knapsack capacity of w
        int[] dp = new int[W + 1];

        // Process each item one by one
        for (int i = 0; i < n; i++) {
            // Traverse backward from capacity W down to the weight of the current item
            // This ensures each item is used at most once
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)