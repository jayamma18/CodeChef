# Maximum Total Subarray Value II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` of length `n` and an integer `k`.

You must select  **exactly**  `k`  **distinct**  subarrays `nums[l..r]` of `nums`. Subarrays may overlap, but the exact same subarray (same `l` and `r`)  **cannot**  be chosen more than once.

The  **value**  of a subarray `nums[l..r]` is defined as: `max(nums[l..r]) - min(nums[l..r])`.

The  **total value**  is the sum of the  **values**  of all chosen subarrays.

Return the  **maximum**  possible total value you can achieve.

 

 **Example 1:** 

 **Input:**  nums = [1,3,2], k = 2

 **Output:**  4

 **Explanation:** 

One optimal approach is:

- Choose nums[0..1] = [1, 3]. The maximum is 3 and the minimum is 1, giving a value of 3 - 1 = 2.
- Choose nums[0..2] = [1, 3, 2]. The maximum is still 3 and the minimum is still 1, so the value is also 3 - 1 = 2.

Adding these gives `2 + 2 = 4`.

 **Example 2:** 

 **Input:**  nums = [4,2,5,1], k = 3

 **Output:**  12

 **Explanation:** 

One optimal approach is:

- Choose nums[0..3] = [4, 2, 5, 1]. The maximum is 5 and the minimum is 1, giving a value of 5 - 1 = 4.
- Choose nums[1..3] = [2, 5, 1]. The maximum is 5 and the minimum is 1, so the value is also 4.
- Choose nums[2..3] = [5, 1]. The maximum is 5 and the minimum is 1, so the value is again 4.

Adding these gives `4 + 4 + 4 = 12`.

 

 **Constraints:** 

- 1 <= n == nums.length <= 5 * 10​​​​​​​4
- 0 <= nums[i] <= 109
- 1 <= k <= min(105, n * (n + 1) / 2)

## Solution

**Language:** Java  
**Runtime:** 1124 ms (beats 5.49%)  
**Memory:** 62.5 MB (beats 100.00%)  
**Submitted:** 2026-11-01T11:10:18.240Z  

```java
import java.util.*;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Binary search for the threshold value V
        int low = 0, high = 1_000_000_000;
        int V = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countGreaterEqual(nums, mid) >= k) {
                V = mid;
                low = mid + 1; // Try to find a larger minimum value
            } else {
                high = mid - 1;
            }
        }
        
        // Step 2: Accumulate all subarrays with value >= V + 1
        long totalSum = 0;
        int ansCnt = 0;
        int targetV = V + 1;
        
        int r = 0;
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        
        for (int l = 0; l < n; l++) {
            while (r < n) {
                while (!maxDq.isEmpty() && nums[maxDq.peekLast()] <= nums[r]) maxDq.pollLast();
                while (!minDq.isEmpty() && nums[minDq.peekLast()] >= nums[r]) minDq.pollLast();
                maxDq.addLast(r);
                minDq.addLast(r);
                
                int curMax = nums[maxDq.peekFirst()];
                int curMin = nums[minDq.peekFirst()];
                
                if (curMax - curMin >= targetV) {
                    break; 
                }
                r++;
            }
            
            if (r < n) {
                // All subarrays from r' = r to n-1 have value >= V + 1
                int curMax = nums[maxDq.peekFirst()];
                int curMin = nums[minDq.peekFirst()];
                
                for (int rPrime = r; rPrime < n; rPrime++) {
                    curMax = Math.max(curMax, nums[rPrime]);
                    curMin = Math.min(curMin, nums[rPrime]);
                    totalSum += (curMax - curMin);
                    ansCnt++;
                }
            }
            
            // Clean deques for next left boundary
            if (!maxDq.isEmpty() && maxDq.peekFirst() == l) maxDq.pollFirst();
            if (!minDq.isEmpty() && minDq.peekFirst() == l) minDq.pollFirst();
            if (r == l) r++;
        }
        
        // Step 3: Top off the remaining subarrays up to k using value V
        if (ansCnt < k) {
            totalSum += (long) (k - ansCnt) * V;
        }
        
        return totalSum;
    }
    
    // Counts how many subarrays have max - min >= V in O(N) time
    private long countGreaterEqual(int[] nums, int V) {
        if (V <= 0) {
            long n = nums.length;
            return n * (n + 1) / 2;
        }
        
        int n = nums.length;
        long cnt = 0;
        int r = 0;
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        
        for (int l = 0; l < n; l++) {
            while (r < n) {
                while (!maxDq.isEmpty() && nums[maxDq.peekLast()] <= nums[r]) maxDq.pollLast();
                while (!minDq.isEmpty() && nums[minDq.peekLast()] >= nums[r]) minDq.pollLast();
                maxDq.addLast(r);
                minDq.addLast(r);
                
                int curMax = nums[maxDq.peekFirst()];
                int curMin = nums[minDq.peekFirst()];
                
                if (curMax - curMin >= V) {
                    break;
                }
                r++;
            }
            
            if (r < n) {
                cnt += (n - r);
            }
            
            if (!maxDq.isEmpty() && maxDq.peekFirst() == l) maxDq.pollFirst();
            if (!minDq.isEmpty() && minDq.peekFirst() == l) minDq.pollFirst();
            if (r == l) r++;
        }
        
        return cnt;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/maximum-total-subarray-value-ii/)