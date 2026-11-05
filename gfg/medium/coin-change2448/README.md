# Coin Change (Count Ways)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array  **coins[ ]**  representing different denominations of currency and an integer  **sum**, find the number of ways you can make sum by using different combinations from coins[ ]. 
 **Note:**  Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer. 

 **Examples:** 

```
Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].

```

```
Input: coins[] = [2, 5, 3, 6], sum = 10
Output: 5
Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5].

```

```
Input: coins[] = [5, 10], sum = 3
Output: 0
Explanation: Since all coin denominations are greater than sum, no combination can make the target sum.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T11:46:19.379Z  

```java
class Solution {
    public int count(int[] coins, int sum) {
        // dp[i] will store the number of ways to make change for amount i
        int[] dp = new int[sum + 1];

        // Base case: There is 1 way to make a sum of 0 (by choosing no coins)
        dp[0] = 1;

        // Pick all coins one by one and update the dp[] values
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[sum];
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/coin-change2448/1)