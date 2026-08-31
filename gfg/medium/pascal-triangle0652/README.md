# Pascal Triangle

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a positive integer  **n**, return the  **nth row of  *pascal's triangle***.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.

 **Examples:** 

```
Input: n = 4
Output: [1, 3, 3, 1]
Explanation: 4th row of pascal's triangle is [1, 3, 3, 1].
```

```
Input: n = 5
Output: [1, 4, 6, 4, 1]
Explanation: 5th row of pascal's triangle is [1, 4, 6, 4, 1].

```

```
Input: n = 1
Output: [1]
Explanation: 1st row of pascal's triangle is [1].
```

 **Constraints:** 
1 ≤ n ≤ 30

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T10:00:42.488Z  

```java
import java.util.*;

class Solution {
    public List<Integer> nthRowOfPascalTriangle(int n) {
        List<Integer> row = new ArrayList<>();
        long val = 1;
        for (int k = 0; k < n; k++) {
            row.add((int)val);
            val = val * (n - 1 - k) / (k + 1);
        }
        return row;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/pascal-triangle0652/1)