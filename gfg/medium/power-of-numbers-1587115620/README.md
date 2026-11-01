# Raise to Power of Its Own Reverse

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a number **n**, find the value of  **n**  raised to the power of its own reverse. The result will always fit into a 32-bit signed integer.

 **Examples:** 

```
Input: n = 2
Output: 4
Explanation: The reverse of 2 is 2, and.
```

```
Input: n = 10
Output: 10
Explanation: The reverse of 10 is 1 (leading zero is discarded), and 10 raised to the power 1 is 10.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:39:02.913Z  

```java
class Solution {
    // GeeksforGeeks driver code expects this exact method name
    public int reverseExponentiation(int n) {
        // Step 1: Find the reverse of the number n
        int temp = n;
        int reverse = 0;
        while (temp > 0) {
            reverse = reverse * 10 + (temp % 10);
            temp /= 10;
        }

        // Step 2: Calculate n raised to the power of reverse
        // Since constraints are small (1 <= n <= 10), Math.pow is perfectly safe
        return (int) Math.pow(n, reverse);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1)