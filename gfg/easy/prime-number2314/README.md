# Prime Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a number  **n**, determine whether it is a  **prime number**  or not.
 **Note:**  A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.

**Examples :
**

```
Input: n = 7
Output: true
Explanation: 7 has exactly two divisors: 1 and 7, making it a prime number.
```

```
Input: n = 25
Output: false
Explanation: 25 has more than two divisors: 1, 5, and 25, so it is not a prime number.
```

```
Input: n = 1
Output: false
Explanation: 1 has only one divisor (1 itself), which is not sufficient for it to be considered prime.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:36:48.228Z  

```java
class Solution {
    static boolean isPrime(int n) {
        // Base cases: Numbers less than or equal to 1 are not prime
        if (n <= 1) {
            return false;
        }

        // 2 and 3 are prime numbers
        if (n <= 3) {
            return true;
        }

        // Eliminate multiples of 2 and 3 quickly
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // Check divisors up to square root of n, skipping multiples of 2 and 3
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/prime-number2314/1)