# Count Occurrences in Sorted

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a sorted array  **arr[]** and a number  **target**, find the number of occurrences of target in given array. 

 **Examples:** 

```
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
```

```
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.

```

```
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:36:57.712Z  

```java
class Solution {
    // Function to count the occurrences of target in a sorted array.
    int countFreq(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);

        // If the element doesn't exist in the array, count is 0
        if (first == -1) {
            return 0;
        }

        int last = findLastOccurrence(arr, target);

        return last - first + 1;
    }

    // Binary Search to find the first occurrence of target
    private int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int firstIdx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                firstIdx = mid;
                high = mid - 1; // Keep searching on the left side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return firstIdx;
    }

    // Binary Search to find the last occurrence of target
    private int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int lastIdx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                lastIdx = mid;
                low = mid + 1; // Keep searching on the right side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastIdx;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1)