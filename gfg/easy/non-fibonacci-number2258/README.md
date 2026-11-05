# Non Fibonacci Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a positive integer  **n**, return the  **nth**  number that does not belong to the fibonacci sequence.

The fibonacci sequence is defined as:

- fib(0) = 0
- fib(1) = 1
- fib(i) = fib(i-1) + fib(i-2), for i > 1

 **Examples:** 

```
Input: n = 5
Output: 10
Explanation: The first 5 non-fibonacci numbers are 4, 6, 7, 9 and 10.
```

```
Input: n = 15
Output: 22
Explanation: The fibonacci numbers up to 22 are 1, 2, 3, 5, 8, 13 and 21. 
The 15th non-fibonacci number is 22.
```

 **Constraints:** 
1 ≤ n ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T07:43:08.084Z  

```java
class Solution {
    public static long nonFibonacci(long n) {
        long prev = 3;
        long curr = 5;

        while (n > 0) {
            long gap = curr - prev - 1;

            if (n <= gap) {
                return prev + n;
            }

            n -= gap;
            long next = prev + curr;
            prev = curr;
            curr = next;
        }

        return 0;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/non-fibonacci-number2258/1)