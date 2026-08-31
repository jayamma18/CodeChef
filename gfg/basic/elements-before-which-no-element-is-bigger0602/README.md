# Count Prefix Maximums

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an array  **arr**  of integers, find the number of elements such that all the elements before them are smaller. The first element is always counted since there are no elements before it.

 **Examples** :

```
Input: arr = [10, 40, 23, 35, 50, 7]
Output: 3
Explanation: The elements 10, 40, and 50 are such that all preceding elements are smaller. Thus, the count is 3.
```

```
Input: arr = [5, 4, 1]
Output: 1
Explanation: Only the first element 5 is such that all preceding elements (none in this case) are smaller. Thus, the count is 1.
```

 **Constraints:** 

1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T10:04:22.884Z  

```java
class Solution {
    public int countElements(int[] arr) {
        int count = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x > maxSoFar) {
                count++;
                maxSoFar = x;
            }
        }
        return count;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/elements-before-which-no-element-is-bigger0602/1)