# Automorphic Number

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a number  **n**, check whether the number is an  **Automorphic**  number or not. A number is called an Automorphic number if and only if the  **square** of the number ends with the number itself.

 **Example 1:** 

```
Input: n = 76
Output: Automorphic
Explanation: 762 = 5776
The square ends with 76, which is the original number. Hence, it is an Automorphic number.
```

 **Example 2:** 

```
Input: N = 14
Output: Not Automorphic
Explanation: 142 = 196
The square does not end with 14. Hence, it is not an Automorphic number.
```

 **Your Task:** 

You don't need to read or print anything. Your task is to complete the function  **isAutomorphic**  **()** which takes n as input parameter and returns "Automorphic" if it is Automorphic number otherwise returns "Not Automorphic"(Without quotes).
 

 **Constranits:** 
1 <= n <= 1000

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T04:46:59.781Z  

```java
class Solution {
    public String isAutomorphic(int n) {
        long sq = (long) n * n;

        // Loop while there are digits left in n
        while (n > 0) {
            if (n % 10 != sq % 10) return "Not Automorphic";
            n /= 10;
            sq /= 10;
        }

        return "Automorphic";
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/automorphic-number4721/1)