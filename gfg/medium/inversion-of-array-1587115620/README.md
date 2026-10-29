# Count Inversions

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers  **arr[]**. You have to find the Inversion Count of the array. Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

 **Examples:** 

```
Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
```

```
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
```

```
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T09:38:59.583Z  

```java
class Solution {
    // Main function to return inversion count
    int inversionCount(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Function to handle divide and conquer splits
    private int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = l + (r - l) / 2;

            // Count inversions in the left subarray
            count += mergeSortAndCount(arr, l, m);

            // Count inversions in the right subarray
            count += mergeSortAndCount(arr, m + 1, r);

            // Count split inversions during merge stage
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    // Function to merge two sorted halves and calculate split inversions
    private int mergeAndCount(int[] arr, int l, int m, int r) {
        // Create copies of sub-segments
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];

        for (int i = 0; i < left.length; i++) left[i] = arr[l + i];
        for (int i = 0; i < right.length; i++) right[i] = arr[m + 1 + i];

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                // Core Logic: If left[i] > right[j], then all remaining elements 
                // from left[i] to left[left.length - 1] form an inversion pair with right[j]
                swaps += (left.length - i);
            }
        }

        // Clean up remaining elements
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];

        return swaps;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1)