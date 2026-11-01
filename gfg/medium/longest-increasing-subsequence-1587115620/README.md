# Longest Increasing Subsequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of non-negative integers, find the length of the Longest Strictly Increasing Subsequence (LIS). A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

 **Examples:** 

```
Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.
```

```
Input: arr[] = [10, 6, 3, 11, 7, 15]
Output: 3
Explanation: One of the possible longest strictly increasing subsequences is [10, 11, 15], which has a length of 3.
```

```
Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:49:01.964Z  

```java
import java.util.ArrayList;

class Solution {
    // Function to find length of longest strictly increasing subsequence.
    public int lis(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // tail[i] will store the smallest tail of all increasing subsequences of length i+1
        ArrayList<Integer> tail = new ArrayList<>();

        for (int num : arr) {
            // Find the position of num in tail using Binary Search
            int idx = binarySearch(tail, num);

            // If num is greater than all elements in tail, append it
            if (idx == tail.size()) {
                tail.add(num);
            } else {
                // Otherwise, replace the existing element to maintain a smaller tail candidate
                tail.set(idx, num);
            }
        }

        return tail.size();
    }

    // Standard Binary Search to find the first element >= target (Lower Bound)
    private int binarySearch(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == target) {
                return mid; // For strictly increasing, identical elements should replace themselves
            } else if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1)