# Subarrays Distinct Element Sum of Squares II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a  **0-indexed** integer array `nums`.

The  **distinct count**  of a subarray of `nums` is defined as:

- Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].

Return  *the sum of the  **squares**  of  **distinct counts**  of all subarrays of* `nums`.

Since the answer may be very large, return it  **modulo**  `109 + 7`.

A subarray is a contiguous  **non-empty**  sequence of elements within an array.

 

 **Example 1:** 

```
Input: nums = [1,2,1]
Output: 15
Explanation: Six possible subarrays are:
[1]: 1 distinct value
[2]: 1 distinct value
[1]: 1 distinct value
[1,2]: 2 distinct values
[2,1]: 2 distinct values
[1,2,1]: 2 distinct values
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 + 22 + 22 + 22 = 15.

```

 **Example 2:** 

```
Input: nums = [2,2]
Output: 3
Explanation: Three possible subarrays are:
[2]: 1 distinct value
[2]: 1 distinct value
[2,2]: 1 distinct value
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 = 3.
```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 187 ms (beats 45.96%)  
**Memory:** 98.1 MB (beats 71.46%)  
**Submitted:** 2026-11-01T11:33:39.069Z  

```java
import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;
    
    // Segment Tree Nodes
    private long[] sum1; // stores sum of x
    private long[] sum2; // stores sum of x^2
    private int[] lazy;  // stores lazy values for addition

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum1 = new long[4 * n];
        sum2 = new long[4 * n];
        lazy = new int[4 * n];

        // Track the last seen index of each number (Constraint: nums[i] <= 10^5)
        int[] lastPos = new int[100005];
        Arrays.fill(lastPos, -1);

        long totalSum = 0;

        for (int j = 0; j < n; j++) {
            int prevIdx = lastPos[nums[j]];
            int startRange = prevIdx + 1;
            int endRange = j;

            // Increment the count of distinct elements by 1 for all subarrays starting in [startRange, endRange]
            update(1, 0, n - 1, startRange, endRange, 1);

            // Add the sum of squares of all subarrays ending at index j to the total answer
            totalSum = (totalSum + sum2[1]) % MOD;

            // Record current position
            lastPos[nums[j]] = j;
        }

        return (int) totalSum;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] == 0) return;
        
        int mid = (l + r) >> 1;
        int leftChild = node << 1;
        int rightChild = (node << 1) | 1;
        int val = lazy[node];

        apply(leftChild, l, mid, val);
        apply(rightChild, mid + 1, r, val);

        lazy[node] = 0;
    }

    private void apply(int node, int l, int r, int val) {
        long len = r - l + 1;
        // (x + val)^2 = x^2 + 2*val*x + val^2 * len
        sum2[node] = (sum2[node] + 2L * val * sum1[node] + (long) val * val % MOD * len) % MOD;
        sum1[node] = (sum1[node] + (long) val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr, int val) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) >> 1;
        if (ql <= mid) {
            update(node << 1, l, mid, ql, qr, val);
        }
        if (qr > mid) {
            update((node << 1) | 1, mid + 1, r, ql, qr, val);
        }
        sum1[node] = (sum1[node << 1] + sum1[(node << 1) | 1]) % MOD;
        sum2[node] = (sum2[node << 1] + sum2[(node << 1) | 1]) % MOD;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/)