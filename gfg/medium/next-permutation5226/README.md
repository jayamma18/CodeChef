# Next Permutation

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers  **arr[]**  representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically smallest greater (or next) permutation.

If no next permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 

 **Examples:** 

```
Input: arr[] = [2, 4, 1, 7, 5, 0]
Output: [2, 4, 5, 0, 1, 7]
Explanation: The next permutation of the given array is [2, 4, 5, 0, 1, 7].
```

```
Input: arr[] = [3, 2, 1]
Output: [1, 2, 3]
Explanation: As arr[] is the last permutation, the next permutation is the lowest one.

```

```
Input: arr[] = [3, 4, 2, 5, 1]
Output: [3, 4, 5, 1, 2]
Explanation: The next permutation of the given array is [3, 4, 5, 1, 2].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T14:10:35.461Z  

```java
class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        // Step 1: Find the first decreasing element from the right (the pivot)
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // If a pivot is found (i.e., array is not entirely descending)
        if (i >= 0) {
            // Step 2: Find the next largest element from the right to swap with pivot
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }

        // Step 3: Reverse the elements to the right of the pivot index
        reverse(arr, i + 1, n - 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/next-permutation5226/1)