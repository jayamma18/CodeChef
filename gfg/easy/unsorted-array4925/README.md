# Left Smaller Right Greater

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an unsorted array `arr[]`, find the first element such that every element to its left is less than or equal to it, and every element to its right is greater than or equal to it.

 **Note:**  If no such element exists, return `-1`.

 **Examples :** 

```
Input: arr = [4, 2, 5, 7]
Output: 5
Explanation: All elements to the left of 5 are less than or equal to 5, and all elements to the right are greater than or equal to 5.
```

```
Input: arr = [11, 9, 12]
Output: -1
Explanation: No element in the array satisfies the required condition.
```

 **Constraints:** 
3 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-19T10:14:03.533Z  

```java
class Solution {
    public int findElement(int[] arr) {
        int n = arr.length;

        int[] rightMin = new int[n];
        rightMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(arr[i], rightMin[i + 1]);
        }

        int leftMax = arr[0];

        for (int i = 1; i < n - 1; i++) {
            if (leftMax <= arr[i] && arr[i] <= rightMin[i + 1]) {
                return arr[i];
            }

            leftMax = Math.max(leftMax, arr[i]);
        }

        return -1;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/unsorted-array4925/1)