# Sort 0s, 1s and 2s

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  containing only 0s, 1s, and 2s **.**  Sort the array in ascending order. 

 **Examples:** 

```
Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
```

```
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
```

 **Follow up:**  Could you come up with a one-pass algorithm using only constant extra space?

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T09:04:23.992Z  

```java
class Solution {
    public void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        // Traverse the array until mid meets high
        while (mid <= high) {
            if (arr[mid] == 0) {
                // If the element is 0, swap it to the lower segment
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // If the element is 1, it's already in the correct relative spot
                mid++;
            } else if (arr[mid] == 2) {
                // If the element is 2, swap it to the higher segment
                swap(arr, mid, high);
                high--;
                // Note: Do not increment mid here because the swapped element from high needs to be evaluated
            }
        }
    }

    // Helper method to swap elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1)