# Number of ZigZag Arrays I

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given three integers `n`, `l`, and `r`.

A  **ZigZag**  array of length `n` is defined as follows:

- Each element lies in the range [l, r].
- No two adjacent elements are equal.
- No three consecutive elements form a strictly increasing or strictly decreasing sequence.

Return the total number of valid  **ZigZag**  arrays.

Since the answer may be large, return it  **modulo**  `109 + 7`.

A  **sequence**  is said to be  **strictly increasing**  if each element is strictly greater than its previous one (if exists).

A  **sequence**  is said to be  **strictly decreasing**  if each element is strictly smaller than its previous one (if exists).

 

 **Example 1:** 

 **Input:**  n = 3, l = 4, r = 5

 **Output:**  2

 **Explanation:** 

There are only 2 valid ZigZag arrays of length `n = 3` using values in the range `[4, 5]`:

- [4, 5, 4]
- [5, 4, 5]​​​​​​​

 **Example 2:** 

 **Input:**  n = 3, l = 1, r = 3

 **Output:**  10

 **Explanation:** 

There are 10 valid ZigZag arrays of length `n = 3` using values in the range `[1, 3]`:

- [1, 2, 1], [1, 3, 1], [1, 3, 2]
- [2, 1, 2], [2, 1, 3], [2, 3, 1], [2, 3, 2]
- [3, 1, 2], [3, 1, 3], [3, 2, 3]

All arrays meet the ZigZag conditions.

 

 **Constraints:** 

- 3 <= n <= 2000
- 1 <= l < r <= 2000

## Solution

**Language:** Java  
**Runtime:** 1699 ms (beats 5.29%)  
**Memory:** 46.2 MB (beats 50.96%)  
**Submitted:** 2026-11-01T11:31:01.600Z  

```java
class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1000000007;
        int k = r - l + 1;
        
        // Base case: for n = 1, there's 1 way for each number, but zigzag rules apply for lengths >= 2.
        // We will initialize the DP table directly for length 2.
        long[][] dp = new long[k][2];
        
        // For length 2:
        // dp[v][0] means decreased to v (so previous u > v). There are (k - 1 - v) such elements.
        // dp[v][1] means increased to v (so previous u < v). There are v such elements.
        for (int v = 0; v < k; v++) {
            dp[v][0] = (k - 1 - v);
            dp[v][1] = v;
        }
        
        // Iteratively process lengths from 3 up to n
        for (int i = 3; i <= n; i++) {
            long[][] nextDp = new long[k][2];
            
            // Optimize transitions using running Prefix and Suffix Sums
            long prefixSum0 = 0; // Tracks sum of dp[u][0] for u < v
            long suffixSum1 = 0; // Tracks sum of dp[u][1] for u > v
            
            // Calculate suffix sums first for dp[u][1] to easily transition to nextDp[v][0]
            for (int u = k - 1; u >= 0; u--) {
                nextDp[u][0] = suffixSum1;
                suffixSum1 = (suffixSum1 + dp[u][1]) % MOD;
            }
            
            // Calculate prefix sums next for dp[u][0] to transition to nextDp[v][1]
            for (int u = 0; u < k; u++) {
                nextDp[u][1] = prefixSum0;
                prefixSum0 = (prefixSum0 + dp[u][0]) % MOD;
            }
            
            dp = nextDp;
        }
        
        // Total sum of all valid configurations of length n
        long totalWays = 0;
        for (int v = 0; v < k; v++) {
            totalWays = (totalWays + dp[v][0] + dp[v][1]) % MOD;
        }
        
        return (int) totalWays;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/number-of-zigzag-arrays-i/)