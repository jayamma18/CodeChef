# Nth Digit

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer `n`, return the `nth` digit of the infinite integer sequence `[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,...]`.

 

 **Example 1:** 

```
Input: n = 3
Output: 3

```

 **Example 2:** 

```
Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,... is a 0, which is part of the number 10.

```

 

 **Constraints:** 

- 1 <= n <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 41.5 MB (beats 92.97%)  
**Submitted:** 2026-11-01T11:01:55.208Z  

```java
class Solution {
    public int findNthDigit(int n) {
        int length = 1;
        long count = 9;
        long start = 1;
        
        // Step 1: Identify the length of the numbers where the nth digit falls
        while (n > length * count) {
            n -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }
        
        // Step 2: Find the exact number that contains the nth digit
        long targetNum = start + (n - 1) / length;
        
        // Step 3: Find the exact digit within that target number
        String numStr = Long.toString(targetNum);
        int digitIndex = (n - 1) % length;
        
        return numStr.charAt(digitIndex) - '0';
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/nth-digit/)