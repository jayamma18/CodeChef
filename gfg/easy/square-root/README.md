# Square Root

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a positive integer  **n,**  find the square root of n. If n is not a perfect square, then return the floor value.

Floor value of any number is the greatest Integer which is less than or equal to that number.

 **Examples:** 

```
Input: n = 4
Output: 2
Explanation: Since, 4 is a perfect square, so its square root is 2.

```

```
Input: n = 11
Output: 3
Explanation: Since, 11 is not a perfect square, floor of square root of 11 is 3.
```

```
Input: n = 1
Output: 1
Explanation: 1 is a perfect square, so its square root is 1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:39:18.817Z  

```java
class Solution {
    int floorSqrt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int low = 1, high = n;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the perfect square root
            if (mid == n / mid) {
                return mid;
            }

            // If mid*mid is less than n, it's a potential floor answer
            if (mid < n / mid) {
                ans = mid;
                low = mid + 1; // Try to find a larger value
            } else {
                high = mid - 1; // mid*mid is greater than n
            }
        }
        return ans;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/square-root/1)