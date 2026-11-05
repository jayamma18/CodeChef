# Largest Odd Number in String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a string `num`, representing a large integer. Return  *the  **largest-valued odd**  integer (as a string) that is a  **non-empty substring**  of* `num` *, or an empty string* `""` *if no odd integer exists*.

A  **substring**  is a contiguous sequence of characters within a string.

 

 **Example 1:** 

```
Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.

```

 **Example 2:** 

```
Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".

```

 **Example 3:** 

```
Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.

```

 

 **Constraints:** 

- 1 <= num.length <= 105
- num only consists of digits and does not contain any leading zeros.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 99.85%)  
**Memory:** 46.6 MB (beats 83.47%)  
**Submitted:** 2026-11-05T09:44:18.470Z  

```java
class Solution {
    public String largestOddNumber(String num) {
        // Scan the string from right to left (backwards)
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            
            // As soon as we find the first odd digit from the right
            if (digit % 2 != 0) {
                // Return the substring from the beginning up to this digit (inclusive)
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd digit is found, return an empty string
        return "";
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/largest-odd-number-in-string/)