# Ways to Reach the n'th Stair

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are **n**  stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time.

Count the number of ways, the person can reach the top  **(order does matter)**. 

 **Examples:** 

```
Input: n = 1
Output: 1
Explanation: There is only one way to climb 1 stair. 
```

```
Input: n = 3
Output: 3
Explanation: The following are three ways to reach the n-th stair.
 
```

```
Input: n = 4
Output: 5
Explanation: There are five ways to reach 4th stair: [1, 1, 1, 1], [1, 1, 2], [2, 1, 1], [1, 2, 1] and [2, 2].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:18:59.989Z  

```java
class Solution {
    // Function to count number of ways to reach the nth stair.
    int countWays(int n) {
        // Base cases
        if (n <= 1) {
            return 1;
        }

        int prev2 = 1; // ways(0)
        int prev1 = 1; // ways(1)
        int current = 0;

        // Iteratively compute ways up to n
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

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1)