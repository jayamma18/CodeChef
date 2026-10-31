# Digits in N that Divide it

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a  **non-negative**  integer  **s**  represented as a string, count the number of digits in s that divide the number represented by s.

A digit is considered valid only if it is non-zero and the number represented by s is  **divisible**  by that digit.

If a digit appears multiple times in s, each occurrence should be counted separately.

 **Examples:** 

```
Input: s = "35"
Output: 1
Explanation: The digit 5 divides 35, but the digit 3 does not. So the answer is 1.
```

```
Input: s = "1122324"
Output: 7
Explanation: Every digit in "1122324" divides 1122324. So the answer is 7.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:07:43.987Z  

```java
class Solution {
    public int divisibleByDigits(String s) {
        // divide[d] will store whether the full number is divisible by digit d
        boolean[] divide = new boolean[10];

        // 1 always divides any non-negative integer
        divide[1] = true;

        // Check divisibility for digits 2 to 9 using modular arithmetic
        for (int digit = 2; digit <= 9; digit++) {
            if (isDivisible(s, digit)) {
                divide[digit] = true;
            }
        }

        int count = 0;

        // Count how many individual digits in s divide the entire number
        for (int i = 0; i < s.length(); i++) {
            int currentDigit = s.charAt(i) - '0';
            if (currentDigit != 0 && divide[currentDigit]) {
                count++;
            }
        }

        return count;
    }

    // Helper function to check if the large string number is divisible by a single digit
    private boolean isDivisible(String s, int digit) {
        int remainder = 0;
        for (int i = 0; i < s.length(); i++) {
            int digitValue = s.charAt(i) - '0';
            remainder = (remainder * 10 + digitValue) % digit;
        }
        return remainder == 0;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-digits-in-given-number-n-which-divide-n3331/1)