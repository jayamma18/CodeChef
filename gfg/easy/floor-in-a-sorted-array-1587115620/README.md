# Floor in Sorted Array

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a sorted array  **arr[]** and an integer  **x**, find the index (0-based) of the largest element in arr[] that is less than or equal to x. This element is called the  **floor**  of x. If such an element does not exist, return -1.

 **Note:**  In case of multiple occurrences of floor of x, return the index of the last occurrence.

 **Examples** 

```
Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
Output: 1
Explanation: Largest number less than or equal to 5 is 2, whose index is 1.
```

```
Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 11
Output: 4
Explanation: Largest Number less than or equal to 11 is 10, whose indices are 3 and 4. The index of last occurrence is 4.

```

```
Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 0
Output: -1
Explanation: No element less than or equal to 0 is found. So, output is -1.
```

 **Constraints:** 
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
0 ≤ x ≤ arr[n-1]

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:49:47.330Z  

```java
class Solution {
    static int findFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If current element is less than or equal to x, it is a potential floor
            if (arr[mid] <= x) {
                ans = mid;        // Record the index
                low = mid + 1;    // Move right to find a larger floor or the last occurrence
            } else {
                high = mid - 1;   // Move left if the current element exceeds x
            }
        }

        return ans;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1)