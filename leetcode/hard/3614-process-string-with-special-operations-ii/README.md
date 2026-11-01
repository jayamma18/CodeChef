# Process String with Special Operations II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a string `s` consisting of lowercase English letters and the special characters: `'*'`, `'#'`, and `'%'`.

You are also given an integer `k`.

Build a new string `result` by processing `s` according to the following rules from left to right:

- If the letter is a lowercase English letter append it to result.
- A '*' removes the last character from result, if it exists.
- A '#' duplicates the current result and appends it to itself.
- A '%' reverses the current result.

Return the `kth` character of the final string `result`. If `k` is out of the bounds of `result`, return `'.'`.

 

 **Example 1:** 

 **Input:**  s = "a#b%*", k = 1

 **Output:**  "a"

 **Explanation:** 

`i`	`s[i]`	Operation	Current `result`
0	`'a'`	Append `'a'`	`"a"`
1	`'#'`	Duplicate `result`	`"aa"`
2	`'b'`	Append `'b'`	`"aab"`
3	`'%'`	Reverse `result`	`"baa"`
4	`'*'`	Remove the last character	`"ba"`

The final `result` is `"ba"`. The character at index `k = 1` is `'a'`.

 **Example 2:** 

 **Input:**  s = "cd%#*#", k = 3

 **Output:**  "d"

 **Explanation:** 

`i`	`s[i]`	Operation	Current `result`
0	`'c'`	Append `'c'`	`"c"`
1	`'d'`	Append `'d'`	`"cd"`
2	`'%'`	Reverse `result`	`"dc"`
3	`'#'`	Duplicate `result`	`"dcdc"`
4	`'*'`	Remove the last character	`"dcd"`
5	`'#'`	Duplicate `result`	`"dcddcd"`

The final `result` is `"dcddcd"`. The character at index `k = 3` is `'d'`.

 **Example 3:** 

 **Input:**  s = "z*#", k = 0

 **Output:**  "."

 **Explanation:** 

`i`	`s[i]`	Operation	Current `result`
0	`'z'`	Append `'z'`	`"z"`
1	`'*'`	Remove the last character	`""`
2	`'#'`	Duplicate the string	`""`

The final `result` is `""`. Since index `k = 0` is out of bounds, the output is `'.'`.

 

 **Constraints:** 

- 1 <= s.length <= 105
- s consists of only lowercase English letters and special characters '*', '#', and '%'.
- 0 <= k <= 1015
- The length of result after processing s will not exceed 1015.

## Solution

**Language:** Java  
**Runtime:** 34 ms (beats 28.07%)  
**Memory:** 47.6 MB (beats 69.59%)  
**Submitted:** 2026-11-01T11:22:41.212Z  

```java
class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n];
        long curLen = 0;

        // Forward Pass: Track string lengths at each index
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (curLen > 0) curLen--;
            } else if (ch == '#') {
                curLen *= 2;
            } else if (ch == '%') {
                // Reversing doesn't change length
            } else {
                curLen++;
            }
            lengths[i] = curLen;
        }

        // Check if k is completely out of bounds
        if (k >= curLen || k < 0) {
            return '.';
        }

        // Backward Pass: Backtrack the target index k
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = (i == 0) ? 0 : lengths[i - 1];

            if (ch == '*') {
                // Skip back over deleted segment tracking
                continue;
            } else if (ch == '#') {
                // If k lies in the duplicated copy half, map it back to the original half
                if (k >= prevLen) {
                    k %= prevLen;
                }
            } else if (ch == '%') {
                // Mirror the index position for the reverse inversion operation
                k = prevLen - 1 - k;
            } else {
                // If ch is a letter and k matches its exact position, return it
                if (k == lengths[i] - 1) {
                    return ch;
                }
            }
        }

        return '.';
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/process-string-with-special-operations-ii/)