# Circular Primes

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer **n**, find all circular prime numbers less than n. A prime number is called a circular prime if all rotations of its digits are also prime numbers.

 **Note:** A rotation is obtained by moving the last digit of a number to the front. For example, the rotations of 197 are 197, 719, and 971.

 **Examples:** 

```
Input: n = 4
Output: [2, 3]
Explanation: 2 and 3 are the circular prime number less than 4.

```

```
Input: n = 197
Output: [2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 113, 131]
Explanation: All the numbers in the output are circular primes less than 197. For example:
13 -> rotations: 13, 31 (both prime)
113 -> rotations: 113, 311, 131 (all prime)
197 is not included because the problem asks for circular primes less than 197.
```

 **Constraints:** 
2 ≤ n ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T06:39:39.120Z  

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> isCircularPrime(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            int x = i, d = (int)Math.pow(10, (int)Math.log10(i));
            boolean ok = true;

            do {
                for (int j = 2; j * j <= x; j++)
                    if (x % j == 0) { ok = false; break; }
                if (!ok) break;
                x = x % 10 * d + x / 10;
            } while (x != i);

            if (ok) ans.add(i);
        }
        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/circular-prime-number0230/1)