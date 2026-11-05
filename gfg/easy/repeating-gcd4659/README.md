# Repeating GCD

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given three integers  **n**,  **x,**  and  **y**. Let  **a** be the number formed by repeating  **n** exactly  **x** times consecutively, and let b be the number formed by repeating  **n** exactly y times consecutively. Find the  **GCD(a, b).** 
 **Note:**  The answer is guaranteed to fit in a 32-bit signed integer.

 **Examples:** 

```
Input: n = 1, x = 1, y = 1
Output: 1
Explanation: 
Repeating 1 exactly once forms a = 1 and b = 1.
Therefore, GCD(1, 1) = 1.

```

```
Input: n = 2, x = 2, y = 3
Output: 2
Explanation: 
Repeating 2 twice forms a = 22, and repeating it three times forms b = 222.
The greatest common divisor of 22 and 222 is 2, so the answer is 2.
```

**Constraints:
**1 ≤ n ≤ 999
1 ≤ x, y ≤ 3

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T07:24:46.977Z  

```java
class Solution {
    public int findGcd(int n, int x, int y) {
        // 1. Calculate the GCD of repetitions (x and y)
        int a = x, b = y;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int repetitions = a;

        // 2. Repeat the number n that many times using built-in repeat()
        String res = String.valueOf(n).repeat(repetitions);

        // 3. Convert back to an integer and return
        return Integer.parseInt(res);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/repeating-gcd4659/1)