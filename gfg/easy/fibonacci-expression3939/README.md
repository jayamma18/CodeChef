# Fibonacci Expression

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a number  **n,** evaluate the following expression. f(n-1) *f(n+1) - f(n)* f(n) where f(n) is the n-th Fibonacci number with n >= 1. Fibonacci Sequence is 0, 1, 1, 2, 3, 5, 8,13,… (here 0 is the 0th Fibonacci number).

 **Examples:** 

```
Input: n = 1
Output: 1
Explanation: f(n+1) *f(n-1) - f(n)* f(n) = 1 *0 - 1* 1 = -1.
```

```
Input: n = 2
Output: 1
Explanation: f(n+1) *f(n-1) - f(n)* f(n) = 2 *1 - 1* 1 = 1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T08:19:10.318Z  

```java
class Solution {
    int fibExpression(int n) {
        // Cassini's Identity: f(n-1)*f(n+1) - f(n)*f(n) = (-1)^n
        // If n is even, (-1)^n is 1. If n is odd, (-1)^n is -1.
        if (n % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/fibonacci-expression3939/1)