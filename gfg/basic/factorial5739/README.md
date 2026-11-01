# Factorial

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a positive integer,  **n**. Find the factorial of  **n**.

 **Examples :** 

```
Input: n = 5
Output: 120
Explanation: 1 x 2 x 3 x 4 x 5 = 120
```

```
Input: n = 4
Output: 24
Explanation: 1 x 2 x 3 x 4 = 24
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:52:17.796Z  

```java
class Solution {
    // Note: If the GFG driver code uses 'int', change the return type to int.
    // If it uses 'long', keep it as long. Both work fine for n <= 12.
    public long factorial(int n) {
        long result = 1;

        // Compute factorial iteratively
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/factorial5739/1)