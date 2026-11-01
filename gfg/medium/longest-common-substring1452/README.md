# Longest Common Substring

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two strings  **s1**  and  **s2**, determine the length of the  **longest substring**  that appears in both strings.

 **Examples:** 

```
Input: s1 = "ABCDGH", s2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" with a length of 4.

```

```
Input: s1 = "abc", s2 = "acb"
Output: 1
Explanation: The longest common substrings are "a", "b", "c" all having length 1.

```

```
Input: s1 = "YZ", s2 = "yz"
Output: 0
Explanation: Comparison is case-sensitive, so 'Y' ≠ 'y' and 'Z' ≠ 'z'. Hence, no common substring exists.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:57:11.140Z  

```java
class Solution {
    // GeeksforGeeks driver code expects this exact method name
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // dp array to store results of the previous row
        int[] dp = new int[m + 1];
        int maxLength = 0;

        for (int i = 1; i <= n; i++) {
            // Traverse backwards to prevent overwriting values needed for the current row
            for (int j = m; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[j]);
                } else {
                    // Substring continuity is broken, reset to 0
                    dp[j] = 0;
                }
            }
        }

        return maxLength;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1)