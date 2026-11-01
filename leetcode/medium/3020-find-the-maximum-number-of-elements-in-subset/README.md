# Find the Maximum Number of Elements in Subset

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array of  **positive**  integers `nums`.

You need to select a subset of `nums` which satisfies the following condition:

- You can place the selected elements in a 0-indexed array such that it follows the pattern: [x, x2, x4,..., xk/2, xk, xk/2,..., x4, x2, x] (Note that k can be any non-negative power of 2). For example, [2, 4, 16, 4, 2] and [3, 9, 3] follow the pattern while [2, 4, 8, 4, 2] does not.

Return  *the  **maximum**  number of elements in a subset that satisfies these conditions.* 

 

 **Example 1:** 

```
Input: nums = [5,4,1,2,2]
Output: 3
Explanation: We can select the subset {4,2,2}, which can be placed in the array as [2,4,2] which follows the pattern and 22 == 4. Hence the answer is 3.

```

 **Example 2:** 

```
Input: nums = [1,3,2,4]
Output: 1
Explanation: We can select the subset {1}, which can be placed in the array as [1] which follows the pattern. Hence the answer is 1. Note that we could have also selected the subsets {2}, {3}, or {4}, there may be multiple subsets which provide the same answer. 

```

 

 **Constraints:** 

- 2 <= nums.length <= 105
- 1 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 59 ms (beats 38.67%)  
**Memory:** 74.4 MB (beats 41.00%)  
**Submitted:** 2026-11-01T11:35:35.136Z  

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put((long) num, counts.getOrDefault((long) num, 0) + 1);
        }

        int maxLength = 1; // Any single element can form a valid sequence of length 1

        // Handle the edge case for 1s
        if (counts.containsKey(1L)) {
            int oneCount = counts.get(1L);
            // Must be an odd length to follow the pattern [1, 1, 1]
            if (oneCount % 2 == 0) {
                maxLength = Math.max(maxLength, oneCount - 1);
            } else {
                maxLength = Math.max(maxLength, oneCount);
            }
        }

        // Process other keys as potential starting bases
        for (long x : counts.keySet()) {
            if (x == 1) continue;

            int currentLength = 0;
            long currentNum = x;

            // Follow the squaring chain while we have at least 2 copies of the number
            while (counts.containsKey(currentNum) && counts.get(currentNum) >= 2) {
                currentLength += 2;
                
                // Guard against potential overflow before squaring
                if (currentNum > 100000) { 
                    currentNum = Long.MAX_VALUE; // Sentinel to break loop
                    break;
                }
                currentNum = currentNum * currentNum;
            }

            // If the next squared number exists at least once, it can be the peak
            if (counts.containsKey(currentNum)) {
                currentLength += 1;
            } else {
                // If it doesn't exist, our last element must act as the peak instead
                currentLength -= 1; 
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/)