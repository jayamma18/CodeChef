# Nth Fibonacci Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Find the  **n-th**  Fibonacci number for a given non-negative integer **n**.
The Fibonacci sequence is defined as:

- F(0) = 0
- F(1) = 1
- F(n) = F(n - 1) + F(n - 2) for n ≥ 2

 **Examples :** 

```
Input: n = 5
Output: 5
Explanation: The 5th Fibonacci number is 5.
```

```
Input: n = 0
Output: 0 
Explanation: The 0th Fibonacci number is 0.

```

```
Input: n = 1
Output: 1
Explanation: The 1st Fibonacci number is 1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T13:22:17.908Z  

```java
class Solution {
    // Function to return the nth Fibonacci number
    public int nthFibonacci(int n) {
        // Base case: F(0) = 0
        if (n == 0) {
            return 0;
        }
        // Base case: F(1) = 1
        if (n == 1) {
            return 1;
        }

        // Track the previous two values
        int prev2 = 0; // F(n-2)
        int prev1 = 1; // F(n-1)
        int current = 0;

        // Compute sequentially up to n
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1)