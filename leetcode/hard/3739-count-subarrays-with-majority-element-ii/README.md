# Count Subarrays With Majority Element II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` and an integer `target`.

Return the number of  **subarrays**  of `nums` in which `target` is the  **majority element**.

The  **majority element**  of a subarray is the element that appears  **strictly more than half**  of the times in that subarray.

 

 **Example 1:** 

 **Input:**  nums = [1,2,2,3], target = 2

 **Output:**  5

 **Explanation:** 

Valid subarrays with `target = 2` as the majority element:

- nums[1..1] = [2]
- nums[2..2] = [2]
- nums[1..2] = [2,2]
- nums[0..2] = [1,2,2]
- nums[1..3] = [2,2,3]

So there are 5 such subarrays.

 **Example 2:** 

 **Input:**  nums = [1,1,1,1], target = 1

 **Output:**  10

 **Explanation:** 

 **​​​​​​​** All 10 subarrays have 1 as the majority element.

 **Example 3:** 

 **Input:**  nums = [1,2,3], target = 4

 **Output:**  0

 **Explanation:** 

`target = 4` does not appear in `nums` at all. Therefore, there cannot be any subarray where 4 is the majority element. Hence the answer is 0.

 

 **Constraints:** 

- 1 <= nums.length <= 10​​​​​​​5
- 1 <= nums[i] <= 10​​​​​​​9
- 1 <= target <= 109

## Solution

**Language:** Java  
**Runtime:** 15 ms (beats 37.10%)  
**Memory:** 87.4 MB (beats 83.33%)  
**Submitted:** 2026-11-01T11:34:29.304Z  

```java
class Solution {
    // Fenwick Tree (Binary Indexed Tree) implementation
    private static class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        void update(int i, int delta) {
            while (i <= size) {
                tree[i] += delta;
                i += i & (-i);
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & (-i);
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        
        // Prefix sums can range from -n to +n. 
        // We map this range to positive values using an offset.
        int offset = n + 1;
        int maxTreeIndex = 2 * n + 2;
        FenwickTree bit = new FenwickTree(maxTreeIndex);

        long validSubarraysCount = 0;
        int currentPrefixSum = 0;

        // Base case: Before elements are processed, prefixSum[0] = 0.
        // We insert the initial sum (0 + offset) into the tree.
        bit.update(0 + offset, 1);

        for (int num : nums) {
            // Transform target elements to +1, others to -1
            if (num == target) {
                currentPrefixSum += 1;
            } else {
                currentPrefixSum -= 1;
            }

            // Query how many previous prefix sums are strictly less than currentPrefixSum
            int queryIndex = currentPrefixSum + offset - 1;
            validSubarraysCount += bit.query(queryIndex);

            // Add the current prefix sum to the Fenwick Tree
            bit.update(currentPrefixSum + offset, 1);
        }

        return validSubarraysCount;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/count-subarrays-with-majority-element-ii/)