# Minimum Operations to Sort a Permutation

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` of length `n`, where `nums` is a permutation of the integers from 0 to `n - 1`.

You may perform  **only**  the following operations:

- Reverse the entire array.
- Rotate Left by One: Move the first element to the end of the array, and rest elements to left by one position.

Return an integer denoting the  **minimum**  number of operations required to sort the array in  **increasing**  order. If it is  **not possible**  to sort the array using only the given operations, return -1.

 

 **Example 1:** 

 **Input:**  nums = [0,2,1]

 **Output:**  2

 **Explanation:** 

- Rotate Left by one: [2, 1, 0]
- Reverse the array: [0, 1, 2]

The array becomes sorted in 2 operations, which is minimal.

 **Example 2:** 

 **Input:**  nums = [1,0,2]

 **Output:**  2

 **Explanation:** 

- Reverse the array: [2, 0, 1]
- Rotate Left by one: [0, 1, 2]

The array becomes sorted in 2 operations, which is minimal.

 **Example 3:** 

 **Input:**  nums = [2,0,1,3]

 **Output:**  -1

 **Explanation:** 

It is impossible to reach `[0, 1, 2, 3]`. Thus, the answer is -1.

 

 **Constraints:** 

- 1 <= n == nums.length <= 105
- 0 <= nums[i] <= n - 1
- nums is a permutation of integers from 0 to n - 1.

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 71.95%)  
**Memory:** 94.7 MB (beats 29.16%)  
**Submitted:** 2026-11-01T11:43:55.481Z  

```java
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // Find the index of 0
        int idx0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
                break;
            }
        }

        // Check if it's a valid forward cyclic shift
        boolean isForward = true;
        for (int i = 0; i < n; i++) {
            if (nums[(i + 1) % n] != (nums[i] + 1) % n) {
                isForward = false;
                break;
            }
        }

        if (isForward) {
            return getForwardCost(idx0, n);
        }

        // Check if it's a valid backward cyclic shift
        boolean isBackward = true;
        for (int i = 0; i < n; i++) {
            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) {
                isBackward = false;
                break;
            }
        }

        if (isBackward) {
            // Option 1: Left shifts until it's [n-1, ..., 0], then Reverse once
            int opt1 = ((idx0 + 1) % n) + 1;
            
            // Option 2: Reverse first, then solve as a forward cyclic shift
            int newIdx0 = n - 1 - idx0;
            int opt2 = 1 + getForwardCost(newIdx0, n);
            
            return Math.min(opt1, opt2);
        }

        // Impossible to sort via rotation and global reversal
        return -1;
    }

    private int getForwardCost(int idx0, int n) {
        if (idx0 == 0) return 0;
        return Math.min(idx0, n - idx0 + 2);
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/)