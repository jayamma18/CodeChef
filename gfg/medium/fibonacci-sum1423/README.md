# Fibonacci Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a number positive number  **n**, find the value of f0 + f1 + f2 +... + fN where fi indicates ith  **Fibonacci** number. Remember that f0 = 0, f1 = 1, f2 = 1, f3 = 2, f4 = 3, f5 = 5,
Since the answer can be very large, the answer takes modulo with  **109 + 7**  and returned.

 **Examples:** 

```
Input: n = 3
Output: 4
Explanation: 0 + 1 + 1 + 2  = 4

```

```
Input: n = 4
Output: 7
Explanation: 0 + 1 + 1 + 2 + 3 = 7

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T08:15:57.961Z  

```java
class Solution {
    static long fibSum(long n) {
        long mod = 1000000007;

        if (n == 0) return 0;
        if (n == 1) return 1;

        long prev = 0; // f0
        long curr = 1; // f1
        long sum = 1;  // f0 + f1

        for (int i = 2; i <= n; i++) {
            long next = (prev + curr) % mod;
            sum = (sum + next) % mod;
            prev = curr;
            curr = next;
        }

        return sum;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/fibonacci-sum1423/1)