# Total Waviness of Numbers in Range II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given two integers `num1` and `num2` representing an  **inclusive**  range `[num1, num2]`.

The  **waviness**  of a number is defined as the total count of its  **peaks**  and  **valleys** :

- A digit is a peak if it is strictly greater than both of its immediate neighbors.
- A digit is a valley if it is strictly less than both of its immediate neighbors.
- The first and last digits of a number cannot be peaks or valleys.
- Any number with fewer than 3 digits has a waviness of 0.
Return the total sum of waviness for all numbers in the range `[num1, num2]`.

 

 **Example 1:** 

 **Input:**  num1 = 120, num2 = 130

 **Output:**  3

 **Explanation:** 

In the range `[120, 130]`:

- 120: middle digit 2 is a peak, waviness = 1.
- 121: middle digit 2 is a peak, waviness = 1.
- 130: middle digit 3 is a peak, waviness = 1.
- All other numbers in the range have a waviness of 0.

Thus, total waviness is `1 + 1 + 1 = 3`.

 **Example 2:** 

 **Input:**  num1 = 198, num2 = 202

 **Output:**  3

 **Explanation:** 

In the range `[198, 202]`:

- 198: middle digit 9 is a peak, waviness = 1.
- 201: middle digit 0 is a valley, waviness = 1.
- 202: middle digit 0 is a valley, waviness = 1.
- All other numbers in the range have a waviness of 0.

Thus, total waviness is `1 + 1 + 1 = 3`.

 **Example 3:** 

 **Input:**  num1 = 4848, num2 = 4848

 **Output:**  2

 **Explanation:** 

Number `4848`: the second digit 8 is a peak, and the third digit 4 is a valley, giving a waviness of 2.

 

 **Constraints:** 

- 1 <= num1 <= num2 <= 1015​​​​​​​

## Solution

**Language:** Java  
**Runtime:** 227 ms (beats 16.02%)  
**Memory:** 46.4 MB (beats 45.63%)  
**Submitted:** 2026-11-01T11:05:57.223Z  

```java
import java.util.Arrays;

class Solution {
    // memo[idx][prev + 1][prev2 + 1][isLess][isStarted] -> [count, waviness]
    private long[][][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long limit) {
        // The absolute smallest number with a valley/peak is 101 (middle '0' is a valley)
        if (limit < 101) return 0; 
        
        String s = Long.toString(limit);
        int n = s.length();
        
        // Initialize memo table with -1
        memo = new long[n][12][12][2][2][2];
        for (long[][][][][] a : memo) {
            for (long[][][][] b : a) {
                for (long[][][] c : b) {
                    for (long[][] d : c) {
                        for (long[] e : d) {
                            Arrays.fill(e, -1);
                        }
                    }
                }
            }
        }
        
        return dfs(0, -1, -1, 0, 0, s)[1];
    }

    private long[] dfs(int idx, int prev, int prev2, int isLess, int isStarted, String s) {
        int n = s.length();
        if (idx == n) {
            return new long[]{isStarted == 1 ? 1 : 0, 0};
        }

        // Shift indices by +1 to handle -1 safely inside the memo table
        if (memo[idx][prev + 1][prev2 + 1][isLess][isStarted][0] != -1) {
            return memo[idx][prev + 1][prev2 + 1][isLess][isStarted];
        }

        int limitDigit = (isLess == 1) ? 9 : (s.charAt(idx) - '0');
        long resCount = 0;
        long resWaviness = 0;

        for (int d = 0; d <= limitDigit; d++) {
            int nextLess = (isLess == 1 || d < limitDigit) ? 1 : 0;

            if (isStarted == 0) {
                if (d == 0) {
                    // Number hasn't started yet (skipping leading zeroes)
                    long[] next = dfs(idx + 1, -1, -1, nextLess, 0, s);
                    resCount += next[0];
                    resWaviness += next[1];
                } else {
                    // Number starts with a non-zero digit
                    long[] next = dfs(idx + 1, d, -1, nextLess, 1, s);
                    resCount += next[0];
                    resWaviness += next[1];
                }
            } else {
                // Number has already started
                int addedWaviness = 0;
                if (prev2 != -1) {
                    if (prev > prev2 && prev > d) {
                        addedWaviness = 1; // Peak found at position idx-1
                    } else if (prev < prev2 && prev < d) {
                        addedWaviness = 1; // Valley found at position idx-1
                    }
                }

                long[] next = dfs(idx + 1, d, prev, nextLess, 1, s);
                resCount += next[0];
                // Accumulate future suffix configurations + current peak matching count combinations
                resWaviness += next[1] + addedWaviness * next[0];
            }
        }

        memo[idx][prev + 1][prev2 + 1][isLess][isStarted][0] = resCount;
        memo[idx][prev + 1][prev2 + 1][isLess][isStarted][1] = resWaviness;
        return memo[idx][prev + 1][prev2 + 1][isLess][isStarted];
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/)