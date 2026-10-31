# Smallest Positive Missing

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array  **arr[]**. Your task is to find the smallest positive number missing from the array.

 **Note:**  Positive number starts from 1. The array can have negative integers too.

 **Examples:** 

```
Input: arr[] = [2, -3, 4, 1, 1, 7]
Output: 3
Explanation: Smallest positive missing number is 3.

```

```
Input: arr[] = [5, 3, 2, 5, 1]
Output: 4
Explanation: Smallest positive missing number is 4.

```

```
Input: arr[] = [-8, 0, -1, -4, -3]
Output: 1
Explanation: Smallest positive missing number is 1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:37:34.517Z  

```java
class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Step 1: Use Cycle Sort to put elements in their correct index positions
        for (int i = 0; i < n; i++) {
            // Keep swapping while the current element is in range [1, n]
            // and is not already at its correct position (arr[i] - 1)
            while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                // Swap arr[i] with the element at its target index
                int targetIdx = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[targetIdx];
                arr[targetIdx] = temp;
            }
        }

        // Step 2: Traverse the rearranged array to find the first mismatch
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // The expected positive number is missing
            }
        }

        // Step 3: If all elements 1 to n are present, the missing number is n + 1
        return n + 1;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1)