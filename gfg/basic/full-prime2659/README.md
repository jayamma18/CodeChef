# Full Prime

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a number N.Check if it is Full Prime or not. 
 **Note**  : A full prime number is one in which the number itself is prime and all its digits are also prime.

 **Example 1:** 

```
Input:
N=31
Output:
0
Explanation:
N is prime but since 1 is not a 
prime so all the digits of N
are not prime.So, Answer is 0.
```

 **Example 2:** 

```
Input:
N=37
Output:
1
Explanation:
N is prime and so is all of its digits.
Thus, Answer is 1.
```

 **Your Task:** 
You don't need to read input or print anything.Your task is to complete the function  **fullPrime()**  which takes the number N as input parameter and returns 1 if the number is Full Prime.Otherwise return 0.

 **Expected Time Complexity:** O(Sqrt(N))
 **Expected Auxillary Space:** O(1)

 **Constraints:** 
1<=N<=109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T05:20:24.640Z  

```java
class Solution {
    static int fullPrime(int N) {
        if (N <= 1) return 0;
        
        int temp = N;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 2 && digit != 3 && digit != 5 && digit != 7) {
                return 0;
            }
            temp /= 10;
        }
        
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) return 0;
        }
        
        return 1;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/full-prime2659/1)