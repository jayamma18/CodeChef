# Peak in Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]** where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist).

If there are multiple peak elements, Return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".

 **Note:**  Consider the element before the first element and the element after the last element to be negative infinity.

**Examples :
**

```
Input: arr = [1, 2, 4, 5, 7, 8, 3]
Output: true
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].
```

```
Input: arr = [10, 20, 15, 2, 23, 90, 80]
Output: true
Explanation: Element 20 at index 1 is a peak since 10 < 20 > 15. Index 5 (value 90) is also a peak, but returning any one peak index is valid.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:38:42.389Z  

```java
class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak element
            // Condition 1: Left neighbor is smaller (or mid is the first element)
            // Condition 2: Right neighbor is smaller (or mid is the last element)
            boolean leftSmaller = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightSmaller = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (leftSmaller && rightSmaller) {
                return mid;
            }

            // If the right neighbor is greater, a peak must exist on the right side
            if (mid < n - 1 && arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else {
                // Otherwise, a peak must exist on the left side
                high = mid - 1;
            }
        }

        return -1; // Fallback, though a peak element always exists
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/peak-element/1)