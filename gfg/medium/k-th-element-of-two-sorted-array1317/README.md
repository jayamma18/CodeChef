# K-th of Two Sorted Arrays

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two sorted arrays  **a[]** and  **b[]**  and an element  **k**, find the element that would be at the  **kth**  position of the combined sorted array.

 **Examples :** 

```
Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.

```

```
Input: a[] = [1, 4, 8, 10, 12], b[] = [5, 7, 11, 15, 17], k = 6
Output: 10
Explanation: Combined sorted array is [1, 4, 5, 7, 8, 10, 11, 12, 15, 17]. The 6th element of this array is 10.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:40:02.397Z  

```java
class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length;
        int m = b.length;

        // Always ensure binary search runs on the smaller array
        if (n > m) {
            return kthElement(b, a, k);
        }

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = k - mid1;

            // Elements around the partition in array a
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int r1 = (mid1 == n) ? Integer.MAX_VALUE : a[mid1];

            // Elements around the partition in array b
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            int r2 = (mid2 == m) ? Integer.MAX_VALUE : b[mid2];

            // Check if valid partition
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                // Too many elements from a, shift left
                high = mid1 - 1;
            } else {
                // Too few elements from a, shift right
                low = mid1 + 1;
            }
        }

        return 0;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1)