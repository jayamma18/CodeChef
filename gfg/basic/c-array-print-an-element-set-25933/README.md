# Find element at a given Index

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an array  **arr[]**  of integers and an index  **i** (0-based index). Return the element present at the index i in the array.

 **Examples:** 

```
Input: i = 2, arr[] = [10, 20, 30, 40, 50]
Output: 30
Explanation: The value of arr[2] is 30.
```

```
Input: i = 4, arr[] = [10, 20, 30, 40, 50, 60, 70]
Output: 50
Explanation: The value of the arr[4] is 50.
```

**Constraints:
**1 ≤ arr.size() ≤ 106
0 ≤ i ≤ arr.size() - 1
1 ≤ arr[i] ≤ 109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T09:59:29.373Z  

```java
class Solution {
    public int findElementAtIndex(int i, int[] arr) {
        return arr[i];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/c-array-print-an-element-set-25933/1)