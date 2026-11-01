# Concatenate Non-Zero Digits and Multiply by Sum II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a string `s` of length `m` consisting of digits. You are also given a 2D integer array `queries`, where `queries[i] = [li, ri]`.

For each `queries[i]`, extract the  **substring**  `s[li..ri]`. Then, perform the following:

- Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
- Let sum be the sum of digits in x. The answer is x * sum.

Return an array of integers `answer` where `answer[i]` is the answer to the `ith` query.

Since the answers may be very large, return them  **modulo**  `109 + 7`.

 

 **Example 1:** 

 **Input:**  s = "10203004", queries = [[0,7],[1,3],[4,6]]

 **Output:**  [12340, 4, 9]

 **Explanation:** 

- s[0..7] = "10203004" x = 1234 sum = 1 + 2 + 3 + 4 = 10 Therefore, answer is 1234 * 10 = 12340.
- s[1..3] = "020" x = 2 sum = 2 Therefore, the answer is 2 * 2 = 4.
- s[4..6] = "300" x = 3 sum = 3 Therefore, the answer is 3 * 3 = 9.

 **Example 2:** 

 **Input:**  s = "1000", queries = [[0,3],[1,1]]

 **Output:**  [1, 0]

 **Explanation:** 

- s[0..3] = "1000" x = 1 sum = 1 Therefore, the answer is 1 * 1 = 1.
- s[1..1] = "0" x = 0 sum = 0 Therefore, the answer is 0 * 0 = 0.

 **Example 3:** 

 **Input:**  s = "9876543210", queries = [[0,9]]

 **Output:**  [444444137]

 **Explanation:** 

- s[0..9] = "9876543210" x = 987654321 sum = 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 45 Therefore, the answer is 987654321 * 45 = 44444444445. We return 44444444445 modulo (109 + 7) = 444444137.

 

 **Constraints:** 

- 1 <= m == s.length <= 105
- s consists of digits only.
- 1 <= queries.length <= 105
- queries[i] = [li, ri]
- 0 <= li <= ri < m

## Solution

**Language:** Java  
**Runtime:** 18 ms (beats 66.84%)  
**Memory:** 128.5 MB (beats 58.29%)  
**Submitted:** 2026-11-01T11:48:47.010Z  

```java
class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1_000_000_007L;

        // Prefix arrays
        int[] cnt = new int[m + 1];
        long[] sum = new long[m + 1];
        long[] val = new long[m + 1];
        long[] power10 = new long[m + 1];

        power10[0] = 1;
        for (int i = 1; i <= m; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }

        // Build prefix arrays
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            int digit = ch - '0';

            if (digit != 0) {
                cnt[i + 1] = cnt[i] + 1;
                sum[i + 1] = sum[i] + digit;
                val[i + 1] = (val[i] * 10 + digit) % MOD;
            } else {
                cnt[i + 1] = cnt[i];
                sum[i + 1] = sum[i];
                val[i + 1] = val[i]; // No change in value magnitude if it's '0'
            }
        }

        int numQueries = queries.length;
        int[] answer = new int[numQueries];

        for (int q = 0; q < numQueries; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            // 1. Get the number of non-zero elements in the range
            int k = cnt[r + 1] - cnt[l];

            if (k == 0) {
                answer[q] = 0;
                continue;
            }

            // 2. Get the sum of digits in the range
            long digitSum = (sum[r + 1] - sum[l]) % MOD;

            // 3. Extract the exact value of x using prefix subtraction
            long x = (val[r + 1] - (val[l] * power10[k]) % MOD + MOD) % MOD;

            // 4. Combine and compute result
            answer[q] = (int) ((x * digitSum) % MOD);
        }

        return answer;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/)